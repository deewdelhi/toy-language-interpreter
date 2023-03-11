import ADT.*;
import Controller.Controller;
import Exception.MyException;
import Expression.*;
import Repository.IRepository;
import Repository.Repository;
import Type.BoolType;
import Type.IntType;
import Type.RefType;
import Type.StringType;
import Value.BoolValue;
import Value.IntValue;
import Value.StringValue;
import Value.Value;
import View.ExitCommand;
import View.RunExample;
import View.TextMenu;
import gui.Gui;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import Statement.*;

public class Interpreter {
    public static void main(String[] v){
        //System.out.println("What do you want to use? \n   1. console \n   2. giu \n\nOption: ");
        //Scanner s = new Scanner(System.in);
        //int num = s.nextInt();
        int num = 2;
        if (num == 1){
            TextMenu menu = new TextMenu();
            menu.addCommand(new ExitCommand("0", "exit"));

            MyIStack<Statement> stk1= new MyStack<>();
            MyIDictionary<String, Value> symtbl1 = new MyDictionary<>();
            MyIList<Value> out1 = new MyList<>();
            MyIDictionary<StringValue, BufferedReader> ft = new MyDictionary<>();
            MyIHeap h1 = new MyHeap();


            Statement ex1= new CompStmt(new VarDecl("v",new IntType()), new CompStmt(new AssignStmt("v",new ValueExp(new IntValue(2))),
                    new PrintStmt(new VarExp("v"))));

            try{
                ex1.typecheck(new MyDictionary<>());
                PrgState prgState1 = new PrgState(stk1, symtbl1, out1, ft, h1, ex1, PrgState.getNumberThread());
                IRepository repo1 = new Repository(prgState1, "log1.txt");
                Controller ctrl1 = new Controller(repo1);
                menu.addCommand(new RunExample("1",ex1.toString(),ctrl1));
            }catch (MyException e){
                System.out.println(e.getMessage());
            }


            MyIStack<Statement> stk2= new MyStack<>();
            MyIDictionary<String, Value> symtbl2 = new MyDictionary<>();
            MyIList<Value> out2 = new MyList<>();
            MyIDictionary<StringValue, BufferedReader> ft2 = new MyDictionary<>();
            MyIHeap h2 = new MyHeap();


            Statement ex2 = new CompStmt(new VarDecl("a", new IntType()), new CompStmt(new VarDecl("b", new IntType()), new CompStmt(new AssignStmt("a", new ArithExp(new ValueExp(new IntValue(2)), new ArithExp(new ValueExp(new IntValue(3)), new ValueExp(new IntValue(5)), '*'), '+')), new CompStmt(new AssignStmt("b", new ArithExp(new VarExp("a"), new ValueExp(new IntValue(1)), '+')), new PrintStmt(new VarExp("b"))))));

            try{
                ex2.typecheck(new MyDictionary<>());
                PrgState prgState2 = new PrgState(stk2, symtbl2, out2, ft2, h2, ex2, PrgState.getNumberThread());
                IRepository repo2 = new Repository(prgState2, "log2.txt");
                Controller ctrl2 = new Controller(repo2);
                menu.addCommand(new RunExample("2",ex2.toString(),ctrl2));
            }catch (MyException e){
                System.out.println(e.getMessage());
            }


            MyIStack<Statement> stk3= new MyStack<>();
            MyIDictionary<String, Value> symtbl3 = new MyDictionary<>();
            MyIList<Value> out3 = new MyList<>();
            MyIDictionary<StringValue, BufferedReader> ft3 = new MyDictionary<>();
            MyIHeap h3 = new MyHeap();

            Statement ex3 = new CompStmt(new VarDecl("a",new BoolType()), new CompStmt(new VarDecl("v", new IntType()),
                    new CompStmt(new AssignStmt("a", new ValueExp(new BoolValue(true))), new CompStmt(new IfStmt(new VarExp("a"),new AssignStmt("v",new ValueExp(new IntValue(2))), new AssignStmt("v", new ValueExp(new IntValue(3)))), new PrintStmt(new
                            VarExp("v"))))));

            try{
                ex3.typecheck(new MyDictionary<>());
                PrgState prgState3 = new PrgState(stk3, symtbl3, out3, ft3,h3, ex3, PrgState.getNumberThread());
                IRepository repo3 = new Repository(prgState3, "log3.txt");
                Controller ctrl3 = new Controller(repo3);
                menu.addCommand(new RunExample("3",ex3.toString(),ctrl3));
            }catch (MyException e){
                System.out.println(e.getMessage());
            }


            MyIStack<Statement> stk4= new MyStack<>();
            MyIDictionary<String, Value> symtbl4 = new MyDictionary<>();
            MyIList<Value> out4 = new MyList<>();
            MyIDictionary<StringValue, BufferedReader> ft4 = new MyDictionary<>();
            MyIHeap h4 = new MyHeap();

            Statement ex4 = new CompStmt(new VarDecl("varf", new StringType()), new CompStmt(new AssignStmt("varf", new ValueExp(new StringValue("test.in"))),
                    new CompStmt(new OpenRFile(new VarExp("varf")), new CompStmt(new VarDecl("varc", new IntType()), new CompStmt(
                            new ReadFile(new VarExp("varf"), "varc"), new CompStmt(new PrintStmt(new VarExp("varc")), new CompStmt(
                            new ReadFile(new VarExp("varf"), "varc"), new CompStmt(new PrintStmt(new VarExp("varc")), new CloseRFile(
                            new VarExp("varf"))))))))));

            try{
                ex4.typecheck(new MyDictionary<>());
                PrgState prgState4 = new PrgState(stk4, symtbl4, out4, ft4,h4, ex4, PrgState.getNumberThread());
                IRepository repo4 = new Repository(prgState4, "log4.txt");
                Controller ctrl4 = new Controller(repo4);
                menu.addCommand(new RunExample("4",ex4.toString(),ctrl4));
            }catch (MyException e){
                System.out.println(e.getMessage());
            }


            MyIStack<Statement> stk5= new MyStack<>();
            MyIDictionary<String, Value> symtbl5 = new MyDictionary<>();
            MyIList<Value> out5 = new MyList<>();
            MyIDictionary<StringValue, BufferedReader> ft5 = new MyDictionary<>();
            MyIHeap h5 = new MyHeap();


            Statement ex5 = new CompStmt(new VarDecl("a",new BoolType()), new CompStmt(new VarDecl("v", new IntType()),
                    new CompStmt(new AssignStmt("a", new ValueExp(new BoolValue(true))), new CompStmt(new IfStmt(new RelationalExp( new ValueExp(new IntValue(2)), new ValueExp(new IntValue(3)), 1),
                            new AssignStmt("v",new ValueExp(new IntValue(2))), new AssignStmt("v", new ValueExp(new IntValue(3)))),
                            new PrintStmt(new VarExp("v"))))));

            try{
                ex5.typecheck(new MyDictionary<>());
                PrgState prgState5 = new PrgState(stk5, symtbl5, out5, ft5, h5, ex5, PrgState.getNumberThread());
                IRepository repo5 = new Repository(prgState5, "log5.txt");
                Controller ctrl5 = new Controller(repo5);
                menu.addCommand(new RunExample("5",ex5.toString(),ctrl5));
            }catch (MyException e){
                System.out.println(e.getMessage());
            }



            MyIStack<Statement> stk6= new MyStack<>();
            MyIDictionary<String, Value> symtbl6 = new MyDictionary<>();
            MyIList<Value> out6 = new MyList<>();
            MyIDictionary<StringValue, BufferedReader> ft6 = new MyDictionary<>();
            MyIHeap h6 = new MyHeap();


            Statement ex6 = new CompStmt(new VarDecl("v", new RefType(new IntType())),
                    new CompStmt(new NewStmt("v", new ValueExp(new IntValue(20))),
                            new CompStmt(new VarDecl("a", new RefType(new RefType(new IntType()))),
                                    new CompStmt(new NewStmt("a", new VarExp("v")),
                                            new CompStmt(new PrintStmt(new VarExp("v")), new PrintStmt(new VarExp("a")))))));

            try{
                ex6.typecheck(new MyDictionary<>());
                PrgState prgState6 = new PrgState(stk6, symtbl6, out6, ft6, h6, ex6, PrgState.getNumberThread());
                IRepository repo6 = new Repository(prgState6, "log6.txt");
                Controller ctrl6 = new Controller(repo6);
                menu.addCommand(new RunExample("6",ex6.toString(),ctrl6));//other prg
            }catch (MyException e){
                System.out.println(e.getMessage());
            }




            MyIStack<Statement> stk7= new MyStack<>();
            MyIDictionary<String, Value> symtbl7 = new MyDictionary<>();
            MyIList<Value> out7 = new MyList<>();
            MyIDictionary<StringValue, BufferedReader> ft7 = new MyDictionary<>();
            MyIHeap h7 = new MyHeap();


            Statement ex7 = new CompStmt(new VarDecl("v", new RefType(new IntType())),
                    new CompStmt(new NewStmt("v", new ValueExp(new IntValue(20))),
                            new CompStmt(new VarDecl("a", new RefType(new RefType(new IntType()))),
                                    new CompStmt(new NewStmt("a", new VarExp("v")),
                                            new CompStmt(new PrintStmt(new ReadHeap(new VarExp("v"))),
                                                    new PrintStmt(new ArithExp(new ReadHeap(new ReadHeap(new VarExp("a"))), new ValueExp(new IntValue(5)), '+')))))));


            try{
                ex7.typecheck(new MyDictionary<>());
                PrgState prgState7 = new PrgState(stk7, symtbl7, out7, ft7, h7, ex7, PrgState.getNumberThread());
                IRepository repo7 = new Repository(prgState7, "log7.txt");
                Controller ctrl7 = new Controller(repo7);

                menu.addCommand(new RunExample("7",ex7.toString(),ctrl7));//other prg
            }catch (MyException e){
                System.out.println(e.getMessage());
            }


            MyIStack<Statement> stk8= new MyStack<>();
            MyIDictionary<String, Value> symtbl8 = new MyDictionary<>();
            MyIList<Value> out8 = new MyList<>();
            MyIDictionary<StringValue, BufferedReader> ft8 = new MyDictionary<>();
            MyIHeap h8 = new MyHeap();


            Statement ex8 = new CompStmt(new VarDecl("v", new RefType(new IntType())),
                    new CompStmt(new NewStmt("v", new ValueExp(new IntValue(20))),
                            new CompStmt(new PrintStmt(new ReadHeap(new VarExp("v"))),
                                    new CompStmt(new HeapWriting("v", new ValueExp(new IntValue(30))),
                                            new PrintStmt(new ArithExp(new ReadHeap(new VarExp("v")), new ValueExp(new IntValue(5)), '+'))))));

            try{
                ex8.typecheck(new MyDictionary<>());
                PrgState prgState8 = new PrgState(stk8, symtbl8, out8, ft8, h8, ex8, PrgState.getNumberThread());
                IRepository repo8 = new Repository(prgState8, "log8.txt");
                Controller ctrl8 = new Controller(repo8);
                menu.addCommand(new RunExample("8",ex8.toString(),ctrl8));//other prg
            }catch (MyException e){
                System.out.println(e.getMessage());
            }


            MyIStack<Statement> stk9= new MyStack<>();
            MyIDictionary<String, Value> symtbl9 = new MyDictionary<>();
            MyIList<Value> out9 = new MyList<>();
            MyIDictionary<StringValue, BufferedReader> ft9 = new MyDictionary<>();
            MyIHeap h9 = new MyHeap();


            Statement ex9 = new CompStmt(new VarDecl("v", new RefType(new IntType())),
                    new CompStmt(new NewStmt("v", new ValueExp(new IntValue(20))),
                            new CompStmt(new VarDecl("a", new RefType(new RefType(new IntType()))),
                                    new CompStmt(new NewStmt("a", new VarExp("v")),
                                            new CompStmt(new NewStmt("v", new ValueExp(new IntValue(30))),
                                                    new PrintStmt(new ReadHeap(new ReadHeap(new VarExp("a")))))))));


            try{
                ex9.typecheck(new MyDictionary<>());
                PrgState prgState9 = new PrgState(stk9, symtbl9, out9, ft9, h9, ex9, PrgState.getNumberThread());
                IRepository repo9 = new Repository(prgState9, "log9.txt");
                Controller ctrl9 = new Controller(repo9);
                menu.addCommand(new RunExample("9",ex9.toString(),ctrl9));//other prg
            }catch (MyException e){
                System.out.println(e.getMessage());
            }



            MyIStack<Statement> stk10= new MyStack<>();
            MyIDictionary<String, Value> symtbl10 = new MyDictionary<>();
            MyIList<Value> out10 = new MyList<>();
            MyIDictionary<StringValue, BufferedReader> ft10 = new MyDictionary<>();
            MyIHeap h10 = new MyHeap();


            Statement ex10 = new CompStmt(new VarDecl("v", new IntType()), new CompStmt(new VarDecl("a", new RefType(new IntType())), new CompStmt(new AssignStmt("v",
                    new ValueExp(new IntValue(10))), new CompStmt(new NewStmt("a", new ValueExp(new IntValue(22))), new CompStmt(
                    new ForkStmt(new CompStmt(new HeapWriting("a", new ValueExp(new IntValue(30))), new CompStmt(new AssignStmt("v", new ValueExp(
                            new IntValue(32))), new CompStmt(new PrintStmt(new VarExp("v")), new PrintStmt(new ReadHeap(new VarExp("a"))))))),
                    new CompStmt(new PrintStmt(new VarExp("v")), new PrintStmt(new ReadHeap(new VarExp("a")))))))));


            try{
                ex10.typecheck(new MyDictionary<>());
                PrgState prgState10 = new PrgState(stk10, symtbl10, out10, ft10, h10, ex10, PrgState.getNumberThread());
                IRepository repo10 = new Repository(prgState10, "log10.txt");
                Controller ctrl10  = new Controller(repo10);
                menu.addCommand(new RunExample("10",ex10.toString(),ctrl10));//other prg
            }catch (MyException e){
                System.out.println(e.getMessage());
            }

            //////////////////////////////////////////////////////////////////////////////
            //THE FOR STATEMENT
            MyIStack<Statement> stk222= new MyStack<>();
            MyIDictionary<String, Value> symtbl222 = new MyDictionary<>();
            MyIList<Value> out222 = new MyList<>();
            MyIDictionary<StringValue, BufferedReader> ft222 = new MyDictionary<>();
            MyIHeap h222 = new MyHeap();


            Statement ex222 = new CompStmt(new VarDecl("v", new IntType()), new CompStmt(new VarDecl("a", new RefType(new IntType())), new CompStmt(new NewStmt("a", new ValueExp(new IntValue(20))),
                    new CompStmt(new ForStmt("v", new ValueExp(new IntValue(0)), new ValueExp(new IntValue(3)),
                            new ArithExp(new VarExp("v"), new ValueExp(new IntValue(1)), '+'), new ForkStmt(
                            new CompStmt(new PrintStmt(new VarExp("v")), new AssignStmt("v", new ArithExp(new VarExp("v"),
                                    new ReadHeap(new VarExp("a")), '*')))
                    )),
                            new PrintStmt(new ReadHeap(new VarExp("a")))))));




            try{
                ex222.typecheck(new MyDictionary<>());
                PrgState prgState222 = new PrgState(stk222, symtbl222, out222, ft222, h222, ex222, PrgState.getNumberThread());
                IRepository repo222 = new Repository(prgState222, "log222.txt");
                Controller ctrl222  = new Controller(repo222);
                menu.addCommand(new RunExample("222",ex222.toString(),ctrl222));//other prg
            }catch (MyException e){
                System.out.println(e.getMessage());
            }



             ///////////////////////////////////////////////////////////////////////


            menu.show();
        }
        else if (num == 2){
            List<Statement> st = new ArrayList<Statement>();
            Statement ex1= new CompStmt(new VarDecl("v",new IntType()), new CompStmt(new AssignStmt("v",new ValueExp(new IntValue(2))), new PrintStmt(new VarExp("v"))));
            Statement ex2 = new CompStmt(new VarDecl("a", new IntType()), new CompStmt(new VarDecl("b", new IntType()), new CompStmt(new AssignStmt("a", new ArithExp(new ValueExp(new IntValue(2)), new ArithExp(new ValueExp(new IntValue(3)), new ValueExp(new IntValue(5)), '*'), '+')), new CompStmt(new AssignStmt("b", new ArithExp(new VarExp("a"), new ValueExp(new IntValue(1)), '+')), new PrintStmt(new VarExp("b"))))));
            Statement ex3 = new CompStmt(new VarDecl("a",new BoolType()), new CompStmt(new VarDecl("v", new IntType()), new CompStmt(new AssignStmt("a", new ValueExp(new BoolValue(true))), new CompStmt(new IfStmt(new VarExp("a"),new AssignStmt("v",new ValueExp(new IntValue(2))), new AssignStmt("v", new ValueExp(new IntValue(3)))), new PrintStmt(new VarExp("v"))))));
            Statement ex4 = new CompStmt(new VarDecl("varf", new StringType()), new CompStmt(new AssignStmt("varf", new ValueExp(new StringValue("test.in"))), new CompStmt(new OpenRFile(new VarExp("varf")), new CompStmt(new VarDecl("varc", new IntType()), new CompStmt(new ReadFile(new VarExp("varf"), "varc"), new CompStmt(new PrintStmt(new VarExp("varc")), new CompStmt(new ReadFile(new VarExp("varf"), "varc"), new CompStmt(new PrintStmt(new VarExp("varc")), new CloseRFile(new VarExp("varf"))))))))));
            Statement ex5 = new CompStmt(new VarDecl("a",new BoolType()), new CompStmt(new VarDecl("v", new IntType()), new CompStmt(new AssignStmt("a", new ValueExp(new BoolValue(true))), new CompStmt(new IfStmt(new RelationalExp( new ValueExp(new IntValue(2)), new ValueExp(new IntValue(3)), 1), new AssignStmt("v",new ValueExp(new IntValue(2))), new AssignStmt("v", new ValueExp(new IntValue(3)))), new PrintStmt(new VarExp("v"))))));
            Statement ex6 = new CompStmt(new VarDecl("v", new RefType(new IntType())), new CompStmt(new NewStmt("v", new ValueExp(new IntValue(20))), new CompStmt(new VarDecl("a", new RefType(new RefType(new IntType()))), new CompStmt(new NewStmt("a", new VarExp("v")), new CompStmt(new PrintStmt(new VarExp("v")), new PrintStmt(new VarExp("a")))))));
            Statement ex7 = new CompStmt(new VarDecl("v", new RefType(new IntType())), new CompStmt(new NewStmt("v", new ValueExp(new IntValue(20))), new CompStmt(new VarDecl("a", new RefType(new RefType(new IntType()))), new CompStmt(new NewStmt("a", new VarExp("v")), new CompStmt(new PrintStmt(new ReadHeap(new VarExp("v"))), new PrintStmt(new ArithExp(new ReadHeap(new ReadHeap(new VarExp("a"))), new ValueExp(new IntValue(5)), '+')))))));
            Statement ex8 = new CompStmt(new VarDecl("v", new RefType(new IntType())), new CompStmt(new NewStmt("v", new ValueExp(new IntValue(20))), new CompStmt(new PrintStmt(new ReadHeap(new VarExp("v"))), new CompStmt(new HeapWriting("v", new ValueExp(new IntValue(30))), new PrintStmt(new ArithExp(new ReadHeap(new VarExp("v")), new ValueExp(new IntValue(5)), '+'))))));
            Statement ex9 = new CompStmt(new VarDecl("v", new RefType(new IntType())), new CompStmt(new NewStmt("v", new ValueExp(new IntValue(20))), new CompStmt(new VarDecl("a", new RefType(new RefType(new IntType()))), new CompStmt(new NewStmt("a", new VarExp("v")), new CompStmt(new NewStmt("v", new ValueExp(new IntValue(30))), new PrintStmt(new ReadHeap(new ReadHeap(new VarExp("a")))))))));
            Statement ex10 = new CompStmt(new VarDecl("v", new IntType()), new CompStmt(new VarDecl("a", new RefType(new IntType())), new CompStmt(new AssignStmt("v", new ValueExp(new IntValue(10))), new CompStmt(new NewStmt("a", new ValueExp(new IntValue(22))), new CompStmt(new ForkStmt(new CompStmt(new HeapWriting("a", new ValueExp(new IntValue(30))), new CompStmt(new AssignStmt("v", new ValueExp(new IntValue(32))), new CompStmt(new PrintStmt(new VarExp("v")), new PrintStmt(new ReadHeap(new VarExp("a"))))))), new CompStmt(new PrintStmt(new VarExp("v")), new PrintStmt(new ReadHeap(new VarExp("a")))))))));
            ////////////////////////////////////////////////////////////////////////////////
            // for



            Statement ex222 = new CompStmt(new VarDecl("v", new IntType()), new CompStmt(new VarDecl("a", new RefType(new IntType())), new CompStmt(new NewStmt("a", new ValueExp(new IntValue(20))),
                    new CompStmt(new ForStmt("v", new ValueExp(new IntValue(0)), new ValueExp(new IntValue(3)),
                            new ArithExp(new VarExp("v"), new ValueExp(new IntValue(1)), '+'), new ForkStmt(
                            new CompStmt(new PrintStmt(new VarExp("v")), new AssignStmt("v", new ArithExp(new VarExp("v"),
                                    new ReadHeap(new VarExp("a")), '*')))
                    )),
                            new PrintStmt(new ReadHeap(new VarExp("a")))))));


            //////////////////////////////////////////////////////////////////


            st.add(ex1);
            st.add(ex2);
            st.add(ex3);
            st.add(ex4);
            st.add(ex5);
            st.add(ex6);
            st.add(ex7);
            st.add(ex8);
            st.add(ex9);
            st.add(ex10);


            ///////////////////////////////////////////////////////////////////////

            st.add(ex222);



             //////////////////////////////////////////////////////////////////////
            Gui.main_gui(v, st);
        }

    }
}