import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * The main class of the Hangman game containing the GUI and the logic of the game.
 * A frame will be created representing the game. The player will have to guess a hidden word. if unsuccessfyl the player will be "hanged" and the game will be over.
 * If the word is guessed, the player can choose to guess another word or exit the program.
 * 
 * @author Nikola 
 * @version 0.5
 */
public class Hangman
{
    // the dictionary class containing the words
    private Dic dictionary;
    // the main frame of the GUI
    private JFrame frame;
    // a string holding all of the used letters
    private String used = "";
    // a sting that will hold the "hidden" representation of the word
    // and will be updated with the guessed letters
    private String hidden;
    // a string holding that cathegory
    private String cat;
    // a lable to show the word that will be used.
    private JLabel word;
    
    // a Jlable to show which letters were used
    private JLabel not;
    // the word that will be used
    private String theWordIs;
    // int showing the number of letters remaining to be revealed
    private int letters;
    // string that holds a message informing the player of the letters left to solve
    // or if the game is over
    private String letter;
    private  JLabel let;
    private JLabel im;
    // boolean to state whether the game is over on still playing
    private boolean over;
    // this value will choose which picture to show
    private int pics;
    
    
    /**
     * Constructor for objects of class Hangman
     * initialize the dictionary class and get the word that the player will be guessing.
     * get the cathegory of the word
     * create the GUI
     * 
     * 
     */
    public Hangman()
    {
        dictionary = new Dic();
        hidden = dictionary.hidden();

        makeFrame();
        newWord();
        over = false;
    }
    
    /**
     * put the "hidden" word representation in the frame.
     */
    public void setWordLable()
    {
        word.setText(hidden);
    }

    /**
     * The main method creating the GUI when the program is started.
     */
    public static void main(String[] args)
    {
        Hangman start = new Hangman();
    }

    /**
     * Create the frame and all of the GUI components.  
     */
    private void makeFrame()
    {
        frame = new JFrame("Hangman");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(new ImageIcon(getClass().getResource("images/00.png")).getImage());
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout(6, 6));
        makeMenuBar(frame);

        JPanel inner = new JPanel();
        inner.setLayout(new BorderLayout(1,1));
        JPanel middle = new JPanel();
        JPanel secound = new JPanel();
        secound.setLayout(new BorderLayout(1,1));
        JPanel outRow = new JPanel();
        JPanel qwe = new JPanel();
        im = new JLabel(new ImageIcon(getClass().getResource("images/0.jpg")));

        JPanel ww = new JPanel();
        word = new JLabel(hidden);

        not = new JLabel(used);
        JPanel lett = new JPanel();
        let = new JLabel(letter);
        lett.add(let);
        ww.add(word);

        contentPane.add(secound, BorderLayout.CENTER);
        contentPane.add(outRow, BorderLayout.SOUTH);
        contentPane.add(not, BorderLayout.NORTH);
        // Frame giving the number of remaining letters to be guessed, and the category of the word.
        secound.add(middle,   BorderLayout.SOUTH);
        secound.add(inner, BorderLayout.CENTER);
        secound.add(lett, BorderLayout.NORTH);
        // Frame with the word to guess
        inner.add(ww, BorderLayout.NORTH);
        inner.add(qwe,  BorderLayout.SOUTH);
        inner.add(im, BorderLayout.CENTER);

        JButton z = new JButton("Z");
        z.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e ) {
                    if(over == false)
                    {
                        if(!theWordIs.contains("z") && !used.contains("Z"))
                        {
                            pictures();
                        }
                        z();
                        not.setText(used);
                        letterCount();

                    }
                }
            }
        );
        outRow.add(z);

        JButton x = new JButton("X");
        x.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e ) {
                    if(over == false)
                    {
                        if(!theWordIs.contains("x") && !used.contains("X"))
                        {
                            pictures();
                        }
                        x();
                        not.setText(used);
                        letterCount();

                    }
                }
            }
        );
        outRow.add(x);

        JButton c = new JButton("C");
        c.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e ) {
                    if(over == false)
                    {
                        if(!theWordIs.contains("c") && !used.contains("C"))
                        {
                            pictures();
                        }
                        c();
                        not.setText(used);
                        letterCount();

                    }
                }
            }
        );
        outRow.add(c);

        JButton v = new JButton("V");
        v.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e ) {
                    if(over == false)
                    {
                        if(!theWordIs.contains("v") && !used.contains("V"))
                        {
                            pictures();
                        }
                        v();
                        not.setText(used);
                        letterCount();

                    }
                }
            }
        );
        outRow.add(v);

        JButton b = new JButton("B");
        b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e ) {
                    if(over == false)
                    {
                        if(!theWordIs.contains("b") && !used.contains("B"))
                        {
                            pictures();
                        }
                        b();
                        not.setText(used);
                        letterCount();

                    }
                }
            }
        );
        outRow.add(b);

        JButton n = new JButton("N");
        n.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e ) {
                    if(over == false)
                    {
                        if(!theWordIs.contains("n") && !used.contains("N"))
                        {
                            pictures();
                        }
                        n();
                        not.setText(used);
                        letterCount();

                    }
                }
            }
        );
        outRow.add(n);

        JButton m = new JButton("M");
        m.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e ) {
                    if(over == false)
                    {
                        if(!theWordIs.contains("m") && !used.contains("M"))
                        {
                            pictures();
                        }
                        m();
                        not.setText(used);
                        letterCount();

                    }
                }
            }
        );
        outRow.add(m);

        JButton a = new JButton("A");
        a.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e ) {
                    if(over == false)
                    {
                        if(!theWordIs.contains("a") && !used.contains("A"))
                        {
                            pictures();
                        }
                        String string = "a";
                        String up = "A";
                        char character = 'A';

                        pressed(string, up, character);
                        not.setText(used);
                        letterCount();

                    }
                }
            }
        );
        JButton s = new JButton("S");
        s.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e ) {
                    if(over == false)
                    {
                        if(!theWordIs.contains("s") && !used.contains("S"))
                        {
                            pictures();
                        }
                        s();
                        not.setText(used);
                        letterCount();

                    }
                }
            }
        );
        JButton d = new JButton("D");
        d.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e ) {
                    if(over == false)
                    {
                        if(!theWordIs.contains("d") && !used.contains("D"))
                        {
                            pictures();
                        }
                        d();
                        not.setText(used);
                        letterCount();

                    }
                }
            }
        );
        JButton f = new JButton("F");
        f.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e ) {
                    if(over == false)
                    {
                        if(!theWordIs.contains("f") && !used.contains("F"))
                        {
                            pictures();
                        }
                        f();
                        not.setText(used);
                        letterCount();

                    }
                }
            }
        );
        JButton g = new JButton("G");
        g.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e ) {
                    if(over == false)
                    {
                        if(!theWordIs.contains("g") && !used.contains("G"))
                        {
                            pictures();
                        }
                        g();
                        not.setText(used);
                        letterCount();

                    }
                }
            }
        );
        JButton h = new JButton("H");
        h.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e ) {
                    if(over == false)
                    {
                        if(!theWordIs.contains("h") && !used.contains("H"))
                        {
                            pictures();
                        }
                        h();
                        not.setText(used);
                        letterCount();

                    }
                }
            }
        );
        JButton j = new JButton("J");
        j.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e ) {
                    if(over == false)
                    {
                        if(!theWordIs.contains("j") && !used.contains("J"))
                        {
                            pictures();
                        }
                        j();
                        not.setText(used);
                        letterCount();

                    }
                }
            }
        );
        JButton k = new JButton("K");
        k.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e ) {
                    if(over == false)
                    {
                        if(!used.contains("K") && !theWordIs.contains("k"))
                        {
                            pictures();
                        }
                        k();
                        not.setText(used);
                        letterCount();

                    }
                }
            }
        );
        JButton l = new JButton("L");
        l.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e ) {
                    if(over == false)
                    {
                        if(!theWordIs.contains("l") && !used.contains("L"))
                        {
                            pictures();
                        }
                        l();
                        not.setText(used);
                        letterCount();

                    }
                }
            }
        );

        middle.add(a);
        middle.add(s);
        middle.add(d);
        middle.add(f);
        middle.add(g);
        middle.add(h);
        middle.add(j);
        middle.add(k);
        middle.add(l);

        JButton q = new JButton("Q");
        q.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e ) {
                    if(over == false)
                    {
                        if(!theWordIs.contains("q") && !used.contains("Q"))    
                        {
                            pictures();
                        }
                        q();
                        not.setText(used);
                        letterCount();

                    }
                }
            }
        );
        JButton w = new JButton("W");
        w.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e ) {
                    if(over == false)
                    {
                        if(!theWordIs.contains("w") && !used.contains("W"))
                        {
                            pictures();
                        }
                        w();
                        not.setText(used);
                        letterCount();

                    }
                }
            }
        );
        JButton e = new JButton("E");
        e.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e ) {
                    if(over == false)
                    {
                        if(!theWordIs.contains("e") && !used.contains("E"))
                        {
                            pictures();
                        }
                        e();
                        not.setText(used);
                        letterCount();

                    }
                }
            }
        );
        JButton r = new JButton("R");
        r.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e ) {
                    if(over == false)
                    {
                        if(!theWordIs.contains("r") && !used.contains("R"))
                        {
                            pictures();
                        }
                        r();
                        not.setText(used);
                        letterCount();

                    }
                }
            }
        );
        JButton t = new JButton("T");
        t.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e ) {
                    if(over == false)
                    {
                        if(!theWordIs.contains("t") && !used.contains("T"))
                        {
                            pictures();
                        }
                        t();
                        not.setText(used);
                        letterCount();

                    }
                }
            }
        );
        JButton y = new JButton("Y");
        y.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e ) {
                    if(over == false)
                    {
                        if(!theWordIs.contains("y") && !used.contains("Y"))
                        {
                            pictures();
                        }
                        y();
                        not.setText(used);
                        letterCount();

                    }
                }

            }
        );
        JButton u = new JButton("U");
        u.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e ) {
                    if(over == false)
                    {
                        if(!theWordIs.contains("u") && !used.contains("U"))
                        {
                            pictures();
                        }
                        u();
                        not.setText(used);
                        letterCount();

                    }
                }
            }
        );
        JButton i = new JButton("I");
        i.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e ) {
                    if(over == false)
                    {
                        if(!theWordIs.contains("i") && !used.contains("I"))
                        {
                            pictures();
                        }
                        i();
                        not.setText(used);
                        letterCount();

                    }
                }
            }
        );
        JButton o = new JButton("O");
        o.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e ) {
                    if(over == false)
                    {
                        if(!theWordIs.contains("o")&& !used.contains("O"))
                        {
                            pictures();
                        }
                        o();
                        not.setText(used);
                        letterCount();

                    }
                }
            }
        );
        JButton p = new JButton("P");
        p.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e ) {
                    if(over == false)
                    {
                        if(!theWordIs.contains("p") && !used.contains("P"))
                        {
                            pictures();
                        }
                        p();
                        not.setText(used);
                        letterCount();

                    }
                }
            }
        );

        qwe.add(q);
        qwe.add(w);
        qwe.add(e);
        qwe.add(r);
        qwe.add(t);
        qwe.add(y);
        qwe.add(u);
        qwe.add(i);
        qwe.add(o);
        qwe.add(p);

        frame.pack();
        // place the frame at the center of the screen and show
        Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(ds.width/2 - frame.getWidth()/2, ds.height/2 - frame.getHeight()/2);
        frame.setVisible(true);
    }

    /**
     * Create the main frame's menu bar.
     * 
     * @param frame   The frame that the menu bar should be added to.
     */
    private void makeMenuBar(JFrame frame)
    {
        final int SHORTCUT_MASK =
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();

        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        JMenu menu;
        JMenuItem item;

        menu = new JMenu("Options");
        menubar.add(menu);

        item = new JMenuItem("New word");
        item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    newWord();
                    not.setText(used);
                }
            });

        menu.add(item);

        item = new JMenuItem("Quit");
        item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e ) {
                    quit();
                }
            }
        );
        menu.add(item);

    }

    /**
     * when selecting a new word from the menu it will load all the elements
     */
    private void newWord()
    {
        hidden = "";
        used = "";
        pics = 0;
        over = false;
        dictionary.loadWord();
        theWordIs = dictionary.getWord();
        hidden = dictionary.hidden();
        word.setText(hidden);
        letters = theWordIs.length();

        letterCount();
        im.setIcon(new ImageIcon(getClass().getResource("images/"+pics+".jpg")));
    }

    /**
     * when a word is loaded this method shows how many letters there are in the hidden word, and also gives the category of the word
     */

    private void letterCount()
    {
        letter = "The word has " + letters + " hidden letters! ";
        let.setText(letter);
        if(letters == 0)
            letter = "Congratulations, you guessed the word !";
        let.setText(letter);
    }

    /**
     * loads the pictures that represent the status of the hang level
     */
    private void pictures()
    {   
        pics++;
        if(pics ==7)
        {
            letter = "Game Over ! You died!";
            let.setText(letter);
            im.setIcon(new ImageIcon(getClass().getResource("images/"+pics+".jpg")));
            over = true;
            word.setText(theWordIs);
        }
        else
        {
            im.setIcon(new ImageIcon(getClass().getResource("images/"+pics+".jpg")));
        }
    }

    /**
     * Exits the JVM
     */
    private void quit()
    {
        System.exit(0);
    }

    /**
     * what happens when a button is pressed.
     * the word is checked if it contains the letter,
     * if so, replaces the hidden word symbol with the guessed letter,
     * 
     */
    private void pressed(String string, String up, char character)
    {

        int index;
        if(dictionary.getWord().contains(string))
        {
            index = theWordIs.indexOf(string);
            StringBuilder stringBuff = new StringBuilder(hidden);
            int asd;
            int dsa;
            asd = theWordIs.lastIndexOf(string);
            while(asd > index)
            {

                stringBuff.setCharAt(asd, character);
                dsa = theWordIs.lastIndexOf(up,asd-1);

                asd = dsa;
            }

            stringBuff.setCharAt(index, character);
            stringBuff.setLength(theWordIs.length());
            hidden = stringBuff.toString();
            int count = hidden.length() - hidden.replace("*", "").length();
            letters = count;

            word.setText(hidden);

        }
        if(!used.contains(up))
            used += " "+up;
    }

    private void a()
    {

        String string = "a";
        String up = "A";
        char character = 'A';

        pressed(string, up, character);

        //         int index;
        //         if(dictionary.getWord().contains("a"))
        //         {
        //             index = theWordIs.indexOf("a");
        //             StringBuilder stringBuff = new StringBuilder(hidden);
        //             int asd;
        //             int dsa;
        //             asd = theWordIs.lastIndexOf("a");
        //             while(asd > index)
        //             {
        // 
        //                 stringBuff.setCharAt(asd, 'A');
        //                 dsa = theWordIs.lastIndexOf("A",asd-1);
        // 
        //                 asd = dsa;
        //             }
        // 
        //             stringBuff.setCharAt(index, 'A');
        //             stringBuff.setLength(theWordIs.length());
        //             hidden = stringBuff.toString();
        //             int count = hidden.length() - hidden.replace("*", "").length();
        //             letters = count;
        // 
        //             word.setText(hidden);
        // 
        //         }
        //         if(!used.contains("A"))
        //             used += " A";
    }

    private void b()
    {
        String string = "b";
        String up = "B";
        char character = 'B';

        pressed(string,up, character);
    }

    private void c()
    {

        String string = "c";
        String up = "C";
        char character = 'C';

        pressed(string,up, character);
    }

    private void d()
    {

        String string = "d";
        String up = "D";
        char character = 'D';

        pressed(string,up, character);
    }

    private void e()
    {

        String string = "e";
        String up = "E";
        char character = 'E';

        pressed(string,up, character);
    }

    private void f()
    {

        String string = "f";
        String up = "F";
        char character = 'F';

        pressed(string,up, character);
    }

    private void g()
    {
        String string = "g";
        String up = "G";
        char character = 'G';

        pressed(string,up, character);

    }

    private void h()
    {

        String string = "h";
        String up = "H";
        char character = 'H';

        pressed(string,up, character);
    }

    private void i()
    {

        String string = "i";
        String up = "I";
        char character = 'I';

        pressed(string,up, character);
    }

    private void j()
    {

        String string = "j";
        String up = "J";
        char character = 'J';

        pressed(string,up, character);
    }

    private void k()
    {
        String string = "k";
        String up = "K";
        char character = 'K';

        pressed(string,up, character);
    }

    private void l()
    {
        String string = "l";
        String up = "L";
        char character = 'L';

        pressed(string,up, character);
    }

    private void m()
    {

        String string = "m";
        String up = "M";
        char character = 'M';

        pressed(string,up, character);
    }

    private void n()
    {

        String string = "n";
        String up = "N";
        char character = 'N';

        pressed(string,up, character);
    }

    private void o()
    {
        String string = "o";
        String up = "O";
        char character = 'O';

        pressed(string,up, character);
    }

    private void p()
    {

        String string = "p";
        String up = "P";
        char character = 'P';

        pressed(string,up, character);
    }

    private void q()
    {

        String string = "q";
        String up = "Q";
        char character = 'Q';

        pressed(string,up, character);
    }

    private void r()
    {

        String string = "r";
        String up = "R";
        char character = 'R';

        pressed(string,up, character);
    }

    private void s()
    {

        String string = "s";
        String up = "S";
        char character = 'S';

        pressed(string,up, character);
    }

    private void t()
    {
        String string = "t";
        String up = "T";
        char character = 'T';

        pressed(string,up, character);
    }

    private void u()
    {

        String string = "u";
        String up = "U";
        char character = 'U';

        pressed(string,up, character);
    }

    private void v()
    {

        String string = "v";
        String up = "V";
        char character = 'V';

        pressed(string,up, character);
    }

    private void w()
    {

        String string = "w";
        String up = "W";
        char character = 'W';

        pressed(string,up, character);
    }

    private void x()
    {

        String string = "x";
        String up = "X";
        char character = 'X';

        pressed(string,up, character);
    }

    private void y()
    {

        String string = "y";
        String up = "Y";
        char character = 'Y';

        pressed(string,up, character);
    }

    private void z()
    {

        String string = "z";
        String up = "Z";
        char character = 'Z';

        pressed(string,up, character);
    }

}