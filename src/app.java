import javax.swing.*;
public class app{
    JPanel main = new JPanel();
    JButton cat = new JButton();
    private JComponent[] allComponents = { new JLabel("Welcome"), cat};
    app() {
        for (JComponent comp : allComponents) {
         main.add(comp);
      }
    }

   public JComponent getMainComponent() {
      return main;
   }

    private static void cASGUI(){
        app app = new app();
        JFrame f = new JFrame("SpaceTrader");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(app.getMainComponent());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    public static void main (String[] args) {
        SwingUtilities.invokeLater(new Runnable() 
          {
             public void run() 
             {
                cASGUI();
             }
          });

        /*JFrame f=new JFrame();//creating instance of JFrame

        JButton b=new JButton("click");//creating instance of JButton
        b.setBounds(130,100,100, 40);//x axis, y axis, width, height

        f.add(b);//adding button in JFrame

        f.setSize(400,500);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
        f.pack();
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);*/
    }
}
