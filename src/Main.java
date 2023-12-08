public class Main {
    public static void main(String[] args) {

        //首先创建我们的任务
        App plan_1 = new App();

        //创建一堆目的地
        Point A = new Point(10,10,"A");
        Point B = new Point(0,100,"B");
        Point C = new Point(50,20,"C");
        Point D = new Point(15,100,"D");
        Point E = new Point(200,80,"E");
        Point F = new Point(120,30,"F");
        Point G = new Point(50,0,"G");
        Point H = new Point(30,30,"H");
        Point I = new Point(230,500,"I");
        Point J = new Point(30,10,"J");

        //将目的地全部加入我们的任务
        plan_1.addOneDestiny(A);
        plan_1.addOneDestiny(B);
        plan_1.addOneDestiny(C);
        plan_1.addOneDestiny(D);
        plan_1.addOneDestiny(E);
        plan_1.addOneDestiny(F);
        plan_1.addOneDestiny(G);
        plan_1.addOneDestiny(H);
        plan_1.addOneDestiny(I);
        plan_1.addOneDestiny(J);

        //让APP规划路线
        plan_1.generateMST();
        plan_1.generateRoute();
        //System.out.print(plan_1.getDestinations().size()+"\n");

        //打印路线
        for (Point p : plan_1.getRoutePlan()) {
            System.out.print(p.getName());
            System.out.print("\n");
        }
    }
}