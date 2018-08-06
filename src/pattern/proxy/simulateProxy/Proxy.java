package pattern.proxy.simulateProxy;

import org.apache.commons.io.FileUtils;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.tools.JavaCompiler.CompilationTask;

/**
 * Create by fengguofei
 * Date: 2018/8/5
 * Time: 19:55
 */
public class Proxy {

    public static Object newProxyInstance(Class infce, InvocationHandler h) throws Exception {
        String rt = "\r\n";
        String methodStr = "";
        for(Method m:infce.getMethods()){
            methodStr += "    @Override" + rt +
            "   public void " + m.getName() +"() {" + rt +
            " try{" + rt +
            " Method md = " + infce.getName() + ".class.getMethod(\"" + m.getName() + "\");" + rt +
            " h.invoke(this, md);" + rt +
            " }catch(Exception e){e.printStackTrace();}" + rt +
            "   }";
        }
        String str =
        "package pattern.proxy.simulateProxy;" + rt +
        "import  pattern.proxy.simulateProxy.InvocationHandler;" + rt +
        "import  java.lang.reflect.Method;" + rt +
        "public class $Proxy0 implements " + infce.getName() + " {" + rt +
                "    public $Proxy0(InvocationHandler h) {" + rt +
                "        super();" + rt +
                "        this.h = h;" + rt +
                "    }" + rt +
                " private InvocationHandler h;" + rt +
               methodStr + rt +
                "}";
        //产生代理类的java文件
        String filename = System.getProperty("user.dir") + "\\bin\\pattern\\proxy\\simulateProxy\\$Proxy0.java";
        System.out.println(filename);
        File file = new File(filename);
        FileUtils.writeStringToFile(file, str);

        //编译
        //拿到编译器
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        //文件管理者
        StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
        //获取文件
        Iterable units = fileMgr.getJavaFileObjects(filename);

        List<String> options = new ArrayList<String>();
        options.add("-encoding");
        options.add("UTF-8");
        //编译任务
        CompilationTask t = compiler.getTask(null, fileMgr, null, options, null, units);
        //进行编译
        t.call();
        fileMgr.close();
        //load到内存中
//        ClassLoader cl = ClassLoader.getSystemClassLoader();
//        System.out.println(cl.toString());//sun.misc.Launcher$AppClassLoader@18b4aac2
        DiskClassLoader diskLoader = new DiskClassLoader(System.getProperty("user.dir") + "\\bin\\pattern\\proxy\\simulateProxy");
        Class c = diskLoader.loadClass("pattern.proxy.simulateProxy.$Proxy0");
        System.out.println(c.getName());
        Constructor ctr = c.getConstructor(InvocationHandler.class);
        return ctr.newInstance(h);
    }
}
