import javax.swing.*;

public class functionFrame {

    public functionFrame(DatabaseMethod dm) {
            JFrame f2 = new JFrame();
            MyWindowListener mw = new MyWindowListener();
            f2.addWindowListener(mw);
            f2.setSize(1000, 1000);
            f2.setLocation(0, 0);
            f2.setVisible(true);

            //////////////////////////////////////////////////////////////////
            //功能界

            JPanel p2 = new JPanel();
            p2.setVisible(true);
            p2.setSize(800, 1000);
            p2.setLocation(0, 0);
            p2.setBackground(java.awt.Color.white);
            /////////////////////////////////////////////////////////////////////
            //
            JButton STOCKIN = new JButton("stockin");
            JLabel ST = new JLabel("filename");
            JTextField STO = new JTextField();

            STOCKIN.setBounds(20, 30, 140, 30);
            STO.setBounds(180, 30, 80, 30);
            ST.setBounds(280, 30, 80, 30);
            STOCKIN.addActionListener((e) -> {
                    String input = dm.stockIn(STO.getText());
                    Display display = new Display(input);
            });
            f2.add(STOCKIN);
            f2.add(STO);
            f2.add(ST);


            //////////////////////////////placeorder

            JLabel PL = new JLabel("filename");
            JTextField PLA = new JTextField();
            JButton PLACEORDER = new JButton("placeorder");
            PLACEORDER.addActionListener(e -> {
                    String in = dm.placeOrder(PLA.getText());
                    Display display = new Display(in);
            });
            PLACEORDER.setBounds(20, 80, 140, 30);
            PLA.setBounds(180, 80, 80, 30);
            PL.setBounds(280, 80, 80, 30);
            f2.add(PLACEORDER);
            f2.add(PLA);
            f2.add(PL);

            ///////////////////////////////////////////////update

            JLabel UP = new JLabel("filename");
            JTextField UPD = new JTextField();
            JButton UPDATEORDER = new JButton("updateorder");
            UPDATEORDER.addActionListener(e -> {
                    String input = dm.updateOrder(UPD.getText());
                    Display display = new Display(input);
            });
            UPDATEORDER.setBounds(20, 130, 140, 30);
            UPD.setBounds(180, 130, 80, 30);
            UP.setBounds(280, 130, 80, 30);
            f2.add(UPDATEORDER);
            f2.add(UPD);
            f2.add(UP);

            /////////////////////////////////////////////deleteorder

            JLabel DE = new JLabel("filename");
            JTextField DEL = new JTextField();
            JButton DELETEORDER = new JButton("deleteorder");
            DELETEORDER.addActionListener(e -> {
                    String input = dm.deleteOrder(DEL.getText());
                    Display display = new Display(input);
            });
            DELETEORDER.setBounds(20, 180, 140, 30);
            DEL.setBounds(180, 180, 80, 30);
            DE.setBounds(280, 180, 80, 30);
            f2.add(DELETEORDER);
            f2.add(DEL);
            f2.add(DE);

            /////////////////////////////////////////////getallstaffcount
            JButton GETALLSTAFFCOUNT = new JButton("getallstaffcount");
            GETALLSTAFFCOUNT.addActionListener(e -> {
                    String in = dm.getAllStaffCount();
                    Display display = new Display(in);
            });
            GETALLSTAFFCOUNT.setBounds(20 , 230 , 140 , 30);
            f2.add(GETALLSTAFFCOUNT);

            ////////////////////////////////////////////getContractCount
            JButton GETCONTRACTCOUNT = new JButton("getContractCount");
            GETCONTRACTCOUNT.addActionListener(e -> {
                    int in = dm.getContractCount();
                    Display display = new Display(String.valueOf(in));
            });
            GETCONTRACTCOUNT.setBounds(20 , 280 , 140 , 30);
            f2.add(GETCONTRACTCOUNT);

            ///////////////////////////////////////////getOrderCount
            JButton GETORDERCOUNT = new JButton("getOrderCount");
            GETORDERCOUNT.addActionListener(e -> {
                    int in = dm.getOrderCount();
                    Display display = new Display(String.valueOf(in));
            });
            GETORDERCOUNT.setBounds(20 , 330 , 140 , 30);
            f2.add(GETORDERCOUNT);

            //////////////////////////////////////////getNeverSoldProductCount
            JButton GETNEVER = new JButton("getNeverSoldProductCount");
            GETNEVER.addActionListener(e -> {
                    String input = String.valueOf(dm.getNeverSoldProductCount());
                    Display display = new Display(input);
            });
            GETNEVER.setBounds(20 , 380 , 140 , 30);
            f2.add(GETNEVER);

            //////////////////////////////////////////getFavoriteProductModel
            JButton GETFAV = new JButton("getFavoriteProductModel");
            GETFAV.addActionListener(e -> {
                    String input = dm.getFavoriteProductModel().toString();
                    Display display = new Display(input);
            });
            GETFAV.setBounds(20 , 430 , 140 , 30);
            f2.add(GETFAV);

            //////////////////////////////////////////getAvgStockByCenter
            JButton GETAVG = new JButton("getAvgStockByCenter");
            GETAVG.addActionListener(e -> {
                    String input = dm.getAvgStockByCenter();
                    Display display = new Display(input);
            });
            GETAVG.setBounds(20 , 480 , 140 , 30);
            f2.add(GETAVG);

            //////////////////////////////////////////getProductByNumber
            JTextField GETP = new JTextField();
            JLabel GETPR = new JLabel("Number");
            JButton GETPRO = new JButton("getProductByNumber");
            GETPRO.addActionListener(e -> {
                    String input = dm.getProductByNumber(GETP.getText());
                    Display display = new Display(input);
            });
            GETPRO.setBounds(20 , 530 , 140 , 30);
            GETP.setBounds(180 , 530 , 80 , 30);
            GETPR.setBounds(280 , 530 , 80 , 30);
            f2.add(GETPRO);
            f2.add(GETP);
            f2.add(GETPR);

            ////////////////////////////////////////getContractInfo
            JTextField GETIN = new JTextField();
            JLabel GETI = new JLabel("number");
            JButton GETINFO = new JButton("getContractInfo");
            GETINFO.addActionListener(e -> {
                    String input = dm.getContractInfo(GETIN.getText());
                    System.out.println(input);
                    Display display = new Display(input);
            });
            GETINFO.setBounds(20 , 580 , 140 , 30);
            GETIN.setBounds(180 , 580 , 80 , 30);
            GETI.setBounds(280 , 580 , 80 , 30);
            f2.add(GETINFO);
            f2.add(GETIN);
            f2.add(GETI);
            ///////////////////////////////////////inAllBasicInfo
            JButton INALL = new JButton("inAllBasicInfo");
            INALL.addActionListener(e -> {
                    dm.inAllBasicInfo();
            });
            INALL.setBounds(20 , 630 , 140 , 30);
            f2.add(INALL);

            f2.add(p2);


            ///////////////////////////////////////////////bill

            JLabel BL = new JLabel("findProd");
            JTextField BLD = new JTextField();
            JButton BILL = new JButton("bill");
            BILL.addActionListener(e -> {
                    String input = dm.bill();
                    Display display = new Display(input);
            });
            BILL.setBounds(420, 80, 140, 30);
            BLD.setBounds(580, 80, 80, 30);
            BL.setBounds(680, 80, 80, 30);
            f2.add(BILL);
            f2.add(BL);
            f2.add(BLD);

            ///////////////////////////////////////////////updateOrderType

            JLabel UO = new JLabel("updateOrderType");
            JTextField UOD = new JTextField();
            JButton UPDATEORDERTYPE = new JButton("date");
            UPDATEORDERTYPE.addActionListener(e -> {
                    if(UOD.getText().equals("")){

                    }
                    else{
                            dm.updateOrderType(UOD.getText());
                    }
            });
            UPDATEORDERTYPE.setBounds(420, 130, 140, 30);
            UOD.setBounds(580, 130, 80, 30);
            UO.setBounds(680, 130, 80, 30);
            f2.add(UPDATEORDERTYPE);
            f2.add(UOD);
            f2.add(UO);

            ///////////////////////////////////////////////outputAll

            JLabel OA = new JLabel("outputAll");
            JTextField OAD = new JTextField();
            JTextField OAD2 = new JTextField();
            JButton OUTPUTALL = new JButton("prod_num & cont_num");
            OUTPUTALL.addActionListener(e -> {
                    String input = dm.outputAll(OAD.getText(), OAD2.getText());
                    Display display = new Display(input);
            });
            OUTPUTALL.setBounds(420, 180, 140, 30);
            OA.setBounds(680, 180, 80, 30);
            OAD.setBounds(580, 180, 80, 30);
            OAD2.setBounds(580, 230, 80, 30);
            f2.add(OUTPUTALL);
            f2.add(OAD2);
            f2.add(OAD);
            f2.add(OA);
            ///////////////////////////////////////////////inAll

            JLabel IA = new JLabel("inputAll");
            JTextField IAD = new JTextField();
            JTextField IAD2 = new JTextField();
            JTextField IAD3 = new JTextField();
            JTextField IAD4 = new JTextField();
            JButton INPUTALL = new JButton("inputAll");
            INPUTALL.addActionListener(e -> {
                    if (IAD.getText().equals("")){
                            dm.inAll();
                    }
                    else {
                            dm.inAll(IAD.getText(), IAD2.getText(), IAD3.getText(), IAD4.getText());
                    }
            });
            INPUTALL.setBounds(420, 280, 140, 30);
            IA.setBounds(680, 280, 80, 30);
            IAD.setBounds(580, 280, 80, 30);
            IAD2.setBounds(580, 330, 80, 30);
            IAD3.setBounds(580, 380, 80, 30);
            IAD4.setBounds(580, 430, 80, 30);
            f2.add(INPUTALL);
            f2.add(IAD4);
            f2.add(IAD3);
            f2.add(IAD2);
            f2.add(IAD);
            f2.add(IA);
            ///////////////////////////////////////////////createTrigger

            JLabel CT = new JLabel("createTrigger");

            JButton CREATETRIGGER = new JButton("createTrigger");
            CREATETRIGGER.addActionListener(e -> {
                    dm.createTrigger();
            });
            CREATETRIGGER.setBounds(420, 480, 140, 30);
            CT.setBounds(580, 480, 80, 30);
            f2.add(CREATETRIGGER);
            f2.add(CT);

            ///////////////////////////////////////////////findProd

            JLabel FP = new JLabel("head");
            JTextField FPD = new JTextField();
            JTextField FPD2 = new JTextField();
            JButton FINDPROD = new JButton("findProd");
            FINDPROD.addActionListener(e -> {
                    String input = "";
                    if (FPD.getText().equals("")){
                            input = dm.findProd();
                    }
                    else{
                            input = dm.findProd(FPD.getText(),FPD2.getText());
                    }
                    Display display = new Display(input);
            });
            FINDPROD.setBounds(420, 530, 140, 30);
            FPD.setBounds(580, 530, 80, 30);
            FPD2.setBounds(580, 580, 80, 30);
            FP.setBounds(680, 530, 80, 30);
            f2.add(FINDPROD);
            f2.add(FPD);
            f2.add(FPD2);
            f2.add(FP);
            ///////////////////////////////////////////////findProd2

            JLabel FP2 = new JLabel("head");
            JTextField FPD02 = new JTextField();
            JTextField FPD22 = new JTextField();
            JButton FINDPROD2 = new JButton("findProd2");
            FINDPROD2.addActionListener(e -> {
                    String input = dm.findProd2(FPD02.getText(),FPD22.getText());
                    Display display = new Display(input);
            });
            FINDPROD2.setBounds(420, 630, 140, 30);
            FPD02.setBounds(580, 630, 80, 30);
            FPD22.setBounds(580, 680, 80, 30);
            FP2.setBounds(680, 630, 80, 30);
            f2.add(FINDPROD2);
            f2.add(FPD02);
            f2.add(FPD22);
            f2.add(FP2);
            ///////////////////////////////////////////////createView
            JLabel CV = new JLabel("head");
            JButton CREAYEVIEW = new JButton("createView");
            CREAYEVIEW.addActionListener(e -> {
                    dm.createView();
            });
            CREAYEVIEW.setBounds(420, 730, 140, 30);
            f2.add(CREAYEVIEW);
            f2.add(CV);

    }
    //createTrigger

}
