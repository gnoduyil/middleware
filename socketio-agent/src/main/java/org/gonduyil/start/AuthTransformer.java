package org.gonduyil.start;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.LoaderClassPath;

import java.io.ByteArrayInputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;


public class AuthTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {

        if (className == null) {
            return classfileBuffer;
        }


        if ("org/gonduyil/start/samples/Auth".equals(className)) {
            System.out.println("找到Auth类");

            ClassPool classPool = ClassPool.getDefault();
            classPool.appendClassPath(new LoaderClassPath(loader));
            classPool.appendSystemPath();
            try {
                CtClass ctClass = classPool.makeClass(new ByteArrayInputStream(classfileBuffer));
                CtMethod[] declaredMethods = ctClass.getDeclaredMethods();
                for (CtMethod declaredMethod : declaredMethods) {

                    if ("auth".equals(declaredMethod.getName())) {
                        // 修改auth方法
                        declaredMethod.insertBefore("        if (\"true\".equals(args.get(\"pass\"))) {\n" +
                                "            return true;\n" +
                                "        }");
                    }
                    declaredMethod.insertBefore("System.out.println(\"before invoke"+ declaredMethod.getName() + "\");");
                }
                return ctClass.toBytecode();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return classfileBuffer;
    }
}
