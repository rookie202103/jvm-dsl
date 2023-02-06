package com.dongjiaqiang.jvm.dsl.java.core;


import com.dongjiaqiang.jvm.dsl.java.api.lambda.function._1_Function;
import com.dongjiaqiang.jvm.dsl.java.api.lambda.predicate._1_Predicate;
import com.dongjiaqiang.jvm.dsl.java.api.lambda.predicate._2_Predicate;
import com.dongjiaqiang.jvm.dsl.java.api.util.CodeUtils;

import java.util.List;


class A<T> {
    public static String foo() throws Exception {
        String[] keys = new String[]{"xx", "11"};
        Integer[] values = new Integer[]{1, 2};
        //Map<String,Integer> map = CodeUtils.ofMap(keys,values);
        // System.out.println(map.size());
        return "";
    }

    public static void foo(_1_Function<Integer, Integer> function) {

    }

    public static void bar(List<List<A<Integer>>> xx) {

    }

    public static Object foo(Object x) {
        return x;
    }
}

class B<T> extends A<T> {

    public T b;

    public B(T b) {
        this.b = b;
    }

    public static int m(){
        try{
            return 1;
        }catch (Exception e){
            return 2;
        }finally {

        }
    }
}

public class Example {


    public static void main(String[] args) throws Exception {

//        _LongConsumer longConsumer = new _LongConsumer(){
//            @Override
//            public void accept(long value) throws Exception {
//                System.out.println(value);
//            }
//        };
//        _IntFunction<Long> intFunction  = new _IntFunction<Long>(){
//            @Override
//            public Long apply(int value) throws Exception {
//                return Long.valueOf(value);
//            }
//        };

        /**
         *
         * a.map(i=>i+1).filter(i=>i!=1).map(i=>i.toString()).mkString(",")
         *
         *
         */



        System.out.println(CodeUtils.mkString(CodeUtils.ofList(1,2,3,4),"#",new _2_Predicate<Integer,StringBuilder>(){

           @Override
           public boolean test(Integer integer,StringBuilder stringBuilder) throws Exception {


               _1_Function<Integer,Integer> function1 = new _1_Function<Integer, Integer>() {
                   @Override
                   public Integer apply(Integer integer) throws Exception {
                       return integer+1;
                   }
               };


               _1_Predicate<Integer> predicate = new _1_Predicate<Integer>(){
                   @Override
                   public boolean test(Integer integer) throws Exception {
                       return integer!=2;
                   }
               };

               _1_Function<Integer,String> function2 = new _1_Function<Integer, String>() {
                   @Override
                   public String apply(Integer integer) throws Exception {
                       return String.valueOf(integer);
                   }
               };

               Integer v1 = function1.apply(integer);
               boolean v2 = predicate.test(v1);

               if(v2){

                   String v3 = function2.apply(v1);
                   stringBuilder.append(v3);
                   return true;
               }else{
                   return false;
               }

           }
       }));


//        CodeUtils.dropWhile("xx", new _1_Predicate<Character>() {
//            @Override
//            public boolean test(Character character) throws Exception {
//                return false;
//            }
//        });
//
//        String.valueOf()
//
//
//        String uu = "xxx";
//
//        Optional<Character> optionalCharacter = uu.isEmpty()?Optional.empty():Optional.of(uu.charAt(0));
//
//       longConsumer.accept( intFunction.apply(10));





       // System.out.println();
//       // CodeUtils.ofList(xx.s)
//        List<Integer> xx = new ArrayList<>();
//        new ArrayList<>(xx.subList(0,10));
//        CodeUtils.ofList(xx.subList(xx.size()));
//
//        B<Integer>  x = new B<>(1);
//
//        x instanceof Success
//
//        System.out.println(x.equals(java.util.Optional.empty()));

//        {
//            A.foo();
//        }
//
//        _1_Supplier<Integer> supplier = ()->{
//            return 1;
//        };
//        supplier.get();
//        supplier.get();
//
//        Object xx = null;
//
//        List<Integer> dd = (List<Integer>)(xx);
//
//
//     //   CodeUtils.compare(dd,CodeUtils.ofList(new A(),199));
//        //assert 1==1;
//        CodeUtils.ofMap();
//
//        //  A.foo();
//        Object x = null;
//        SimpleCompiler simpleCompiler = new SimpleCompiler();
//        simpleCompiler.setParentClassLoader(CodeUtils.class.getClassLoader());
//
//        _1_Supplier<Integer> supplier1 = new _1_Supplier<Integer>() {
//            @Override
//            public Integer get() throws Exception {
//                return 10;
//            }
//        };
//        supplier1.get();
//
//        simpleCompiler.cook("" +
//                "import java.util.Map;" +
//                "import com.dongjiaqiang.jvm.dsl.java.core.util.CodeUtils;" +
//                "import com.dongjiaqiang.jvm.dsl.java.core.lambda.supplier._1_Supplier;"+
//                "class A{\n" +
//                "    public static void foo() throws Exception{\n" +
//
//
//                "_1_Supplier<Integer> supplier1 = new _1_Supplier<Integer>() {\n" +
//                "            @Override\n" +
//                "            public Integer get() throws Exception {\n" +
//                "                return 10;\n" +
//                "            }\n" +
//                "        };"+
//
//                "        String[] keys = new String[]{\"xx\",\"11\"};\n" +
//                "        Integer[] values = new Integer[]{1,2};\n" +
//                "        System.out.println( supplier1.get());\n" +
//                "    }\n" +
//                "}");
//       Method method = simpleCompiler.getClassLoader().loadClass("A").getMethod("foo");
//       method.setAccessible(true);
//       method.invoke(null);

//       new _1_Function<Integer,Integer>(){
//           @Override
//           public Integer apply(Integer a) throws Exception {
//               return null;
//           }
//       };
//
//       boolean xx  = method.equals(Optional.empty());

//        new java.util.ArrayList<Integer>();
//
//        Either<Integer, Long> either = new Left<>(12);
//
//        B<Integer> b = new B<>(1);
//
//        int[] x = new int[]{1, 2, 3};


        // byte[] x = new byte[]{1,2};
//        Try<A> aTry = new Success<>(new B());
//        Try<A> nTry = aTry.flatMap(a->{
//            return new Success<>(new B());
//        });
//
//  //      java.util.ArrayList<java.util.ArrayList<Double>> x;
//
//
//        A[] a = new A[]{new B()};

//        Map<Integer, A[]> map = new HashMap<>();
//        //map.put(1,new HashSet<A>());
//
//        java.util.Optional.ofNullable(1);
//        new Tuple3<>(1, 2, 3);
//
//        int xd = 1 & 2;
//
//        // Object x = CodeUtils.ofArray(1,2,3);
//        // A<Integer> a = new ();
//        //    boolean dd = x instanceof int;
//
//        Object x1 = new A();
//        int x2 = (Integer) x1 + 1;
//
//        boolean a = true;
//        boolean b1 = !a;
//        //  CodeUtils.ofMap()
//
//        xd = 10;
//        A.bar(Collections.singletonList(Arrays.asList(new A<>())));
//
//        int finalXd = xd;
//        _2_Function<Integer, Integer, Integer> function = (a1, b2) -> {
//            return finalXd;
//        };
//
//        function.apply(11, 12);
//
//        Try.apply(() -> {
//            throw new IOException("xx");
//        });
//
//        CodeUtils.supplyAsync(() -> {
//            throw new IOException("");
//        });
//
//        List<Integer> list = CodeUtils.ofList(1);
//        for (int i : list) {
//
//        }
//        Map<Integer, String> map1 = new HashMap<>();
//
//        for (java.util.Map.Entry<Integer, String> entry : map1.entrySet()) {
//            int k = entry.getKey();
//            String v = entry.getValue();
//        }
//        int xxxx = 10;
//
//        do
//        {
//            xxxx+=1;
//        }while (xxxx>20);
//
//        synchronized (list){
//
//        }
//
//        try{
//
//        }catch (Exception e){
//
//        }
//
//        List<Object> xxss = (List<Object>)Thread.currentThread();
//
//        xxss.g
//
//       // xxss.si
//        boolean xs = xxss instanceof java.util.List;
//
//        Object xss = Thread.currentThread();
//
//        List<B<Integer>> dddd = (List<B<Integer>>)(xss);
//
//        int sdd = dddd.get(0).b;
//
//        List<List<Tuple3<Integer,Integer,Object>>> p = new ArrayList<>();
//
//        int xds = ((List<Integer>)(((Tuple3<Integer,Integer,Object>)(p.get(0)))._3)).get(1);
//
//        boolean xdz = !(xxss instanceof List && true ==false);
//
//
//        List xsff = (List)dddd;
//        xsff.size()
    }
}
