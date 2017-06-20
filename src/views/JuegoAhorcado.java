/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author ulise
 */
public class JuegoAhorcado extends javax.swing.JFrame {

    //almacena como maximo 20 palabras leidas desde el archivo de texto
    public ImageIcon imgs[];
    public JButton btns[];
    public String palabra[];
    public String ints[];
    public String decr[];
    public int ran;
    public int err;
    public String res[];
    
    Icon Modificar;

    /**
     * Creates new form JuegoAhorcado
     */
    public JuegoAhorcado() {
        initComponents();
        //TAMAÑO DE LOS ARREGLOS
        imgs = new ImageIcon[7];
        btns = new JButton[27];
        palabra = new String[20];
        decr = new String[20];
        ints = new String[6];
        Modificar = new ImageIcon("src/images/mou.jpg");
        
        //Numero de los intentos a imprimir
        ints [0] = "1";
        ints [1] = "2";
        ints [2] = "3";
        ints [3] = "4";
        ints [4] = "5";
        ints [5] = "6";

        //IMAGENES DE EL MONO DEL AHORCADO
        imgs[0] = new ImageIcon(getClass().getResource("/images/ahorcado01.png"));
        imgs[1] = new ImageIcon(getClass().getResource("/images/ahorcado02.png"));
        imgs[2] = new ImageIcon(getClass().getResource("/images/ahorcado03.png"));
        imgs[3] = new ImageIcon(getClass().getResource("/images/ahorcado04.png"));
        imgs[4] = new ImageIcon(getClass().getResource("/images/ahorcado05.png"));
        imgs[5] = new ImageIcon(getClass().getResource("/images/ahorcado06.png"));
        imgs[6] = new ImageIcon(getClass().getResource("/images/ahorcado07.png"));
        
        
        //BOTONES PARA PODER VALIDAR LA LETRA
        btns[1] = jButton2;
        btns[2] = jButton3;
        btns[3] = jButton4;
        btns[4] = jButton5;
        btns[5] = jButton6;
        btns[6] = jButton7;
        btns[7] = jButton8;
        btns[8] = jButton9;
        btns[9] = jButton10;
        btns[10] = jButton11;
        btns[11] = jButton12;
        btns[12] = jButton13;
        btns[13] = jButton14;
        btns[14] = jButton15;
        btns[15] = jButton16;
        btns[16] = jButton17;
        btns[17] = jButton18;
        btns[18] = jButton19;
        btns[19] = jButton20;
        btns[20] = jButton21;
        btns[21] = jButton22;
        btns[22] = jButton23;
        btns[23] = jButton24;
        btns[24] = jButton25;
        btns[25] = jButton26;
        btns[26] = jButton27;
        
        //Esta linea de codigo es para obtener la descrbcion de cada palabra
        decr[0] = "Animal de cuatro patas que ladra";
        decr[1] = "Animal que le hace pío";
        decr[2] = "Animal de cuatro patas que maulla";
        decr[3] = "Reptil parecido a una lagartija pero en tamaño mas grande";
        decr[4] = "Animal considerado con la mejor visión a distancia";
        decr[5] = "Felino de gran tamaño con rayas negras, blancas y naranjado";
        decr[6] = "Mamifero de gran tamaño apreciado por su marfil";
        decr[7] = "Animal de gran altura distinguida por su cuello";
        decr[8] = "Especie de animal que se cree que pudimos evolucionar";
        decr[9] = "Insecto que evoluciona por medio de un capullo";
        decr[10] = "Felino considerado el mas veloz del mundo";
        decr[11] = "Roedor que se distingue por sus grandes orejas";
        decr[12] = "Animal que se camuflajea con su entorno";
        decr[13] = "Pez considerado el rey del oceano";
        decr[14] = "Serpiente que se distingue por su capucha cuando se enoja";
        decr[15] = "Animal que es considerado el rey de la selva";
        decr[16] = "Insecto venenoso con un aguijon en su cola y con tenazas";
        decr[17] = "Animal prehistorico perecido al elefante";
        decr[18] = "Animal de australia que da grandes saltos con sus patas traceras";
        decr[19] = "Anmal mitico que se distingue por escupir fuego";
        
        
        //Esta linea de codigo es para que valide la letra
        palabra[0] = "Perro".toUpperCase();
        palabra[1] = "Pollo".toUpperCase();
        palabra[2] = "Gato".toUpperCase();
        palabra[3] = "Cocodrilo".toUpperCase();
        palabra[4] = "Aguila".toUpperCase();
        palabra[5] = "Tigre".toUpperCase();
        palabra[6] = "Elefante".toUpperCase();
        palabra[7] = "Jirafa".toUpperCase();
        palabra[8] = "Simio".toUpperCase();
        palabra[9] = "Mariposa".toUpperCase();
        palabra[10] = "Leopardo".toUpperCase();
        palabra[11] = "Conejo".toUpperCase();
        palabra[12] = "Camaleon".toUpperCase();
        palabra[13] = "Tiburon".toUpperCase();
        palabra[14] = "Cobra".toUpperCase();
        palabra[15] = "Leon".toUpperCase();
        palabra[16] = "Alacran".toUpperCase();
        palabra[17] = "Mamut".toUpperCase();
        palabra[18] = "Canguro".toUpperCase();
        palabra[19] = "Dragon".toUpperCase();
        
        //se asigna un evento a cada letra para comprobar que exista en la palabra a adivinar
        for (int i = 1; i < 27; i++) {
            btns[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent b) {
                    checarLetra(b);
                }
            });
        }
        iniciar();
    }

    //funcion para comenzar los parametros del juego o iniciar una nueva partida
    public void iniciar() {
        //ERRORES EN 0
        err = 0;
        lbaImage.setIcon(imgs[0]);
        lbaIntentos.setText("0");
        txtPalabra.setText("");
        txtDescripcion.setText("Se presentara puras palabras de animales en este juego del ahorcado");
        //para activar las letras del tablero
        for (int i = 1; i < 27; i++) {
            btns[i].setEnabled(true);
        }
        //para generar una palabra aleatoriamente
        ran = (int) 0 + (int) (Math.random() * ((palabra.length - 1) + 1));
       
        //------------Aqui se supone iba imprimir la descripcion------------------
        
        
        //------------------------------
        //SEPARA LAS PALABRAS POR LETRA CON ESPACIOS 
        String pal[] = palabra[ran].split(" ");
        res = new String[palabra[ran].length() + 1];
        int j = 0;
        // AQUI EN ESTA LINEA DE CODIGO OBTENEMOS LO QUE CAMBIARARIA LA PALABRA POR UN GUION
        for (String pal1 : pal) {
            for (int i = 0; i < pal1.length(); i++) {
                txtPalabra.setText(txtPalabra.getText() + "_ ");
                
                res[j++] = "_";
            }
            txtPalabra.setText(txtPalabra.getText() + "\n");
            
            res[j++] = " ";
            //-----------------------
            
            //----------------------
            
            
            
        }
        
        //-----------
        
        //-----------
    }
    

    //al presionar una letra, esta se buscara si pertenece a la palabra, de lo contrario la marcara como error 
    public void checarLetra(ActionEvent e) {
        JButton bt = (JButton) e.getSource();
        char c[];
        //busca la letra en la palabra despues de haber sido presionada
        for (int i = 1; i < 27; i++) {
            if (bt == btns[i]) {
                //la tecla es inicializada
                c = Character.toChars(64 + i);
                //busca si la letra esta en la frase
                boolean esta = false;
                for (int j = 0; j < palabra[ran].length(); j++) {
                    if (c[0] == palabra[ran].charAt(j)) {
                        res[j] = c[0] + "";
                        esta = true;
                    }
                }
                //SI LA LETRA ESTA EN EL MENSAJE SE MUESTRA EN EL TEXTPANEL
                if (esta) {
                    txtPalabra.setText("");
                    for (String re : res) {
                        if (" ".equals(re)) {
                           txtPalabra.setText(txtPalabra.getText() + "\n");
                        } else {
                            txtPalabra.setText(txtPalabra.getText() + re + " ");
                        }
                    }
                    //hace una comprobacion de las letras restantes y faltantes, en caso de que ya no haya letras sera ganador :D
                    boolean gano = true;
                    for (String re : res) {
                        if (re.equals("_")) {
                            gano = false;
                            break;
                        }
                    }
                    //al ser correcta se muestra un mensaje y se reinicia el juego
                    if (gano) {
                        JOptionPane.showMessageDialog(this, "Ganaste eres un Dios Intergalactico de la NASA!!!");
                        
                        return;
                    }
                    //SI LA LETRA NO ESTA EN EL MENSAGE, SE INCREMENTA EL ERROR Y SE CAMBIA LA IMAGEN
                } else {
                    lbaIntentos.setText(ints[err]);
                    lbaImage.setIcon(imgs[++err]); 
                    //SI SE LLEGA A LOS 6 ERRORES ENTONCES SE PIERDE EL JUEGO Y SE MANDA EL MENSAGE DE:
                    if (err == 6) {
                        JOptionPane.showMessageDialog(this, "Palabra incorrecta la respuesta es: \n" + palabra[ran]);
                        
                        iniciar();
                        return;
                    }
                }
                //esta es la linea que desactiva las letras despues de ser usadas :3
                bt.setEnabled(false);
                break;
            }
        }

    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbaIntentos = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbaImage = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        btnExit = new javax.swing.JButton();
        txtPalabra = new javax.swing.JTextField();
        btnReiniciar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(99, 84, 83));

        jLabel1.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Intentos");

        lbaIntentos.setBackground(new java.awt.Color(204, 204, 204));
        lbaIntentos.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbaIntentos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbaIntentos.setOpaque(true);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Inicio modif.jpg"))); // NOI18N

        jLabel4.setBackground(new java.awt.Color(153, 153, 0));
        jLabel4.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Juego del Ahorcado");
        jLabel4.setOpaque(true);

        lbaImage.setBackground(new java.awt.Color(204, 204, 204));
        lbaImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mou.jpg"))); // NOI18N
        lbaImage.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbaIntentos, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(109, 109, 109)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addComponent(lbaImage, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbaIntentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(lbaImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(99, 84, 83));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(51, 51, 51), null, new java.awt.Color(204, 204, 204)));

        jLabel5.setBackground(new java.awt.Color(102, 102, 0));
        jLabel5.setFont(new java.awt.Font("BankGothic Lt BT", 0, 24)); // NOI18N
        jLabel5.setText("Palabra");
        jLabel5.setOpaque(true);

        jLabel6.setBackground(new java.awt.Color(102, 102, 0));
        jLabel6.setFont(new java.awt.Font("BankGothic Lt BT", 0, 24)); // NOI18N
        jLabel6.setText("Descripción");
        jLabel6.setOpaque(true);

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        txtDescripcion.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtDescripcionAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(txtDescripcion);

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exitsinanimacion.png"))); // NOI18N
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        txtPalabra.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtPalabra.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnReiniciar.setFont(new java.awt.Font("BankGothic Lt BT", 0, 18)); // NOI18N
        btnReiniciar.setText("Reiniciar");
        btnReiniciar.setToolTipText("");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });

        jButton2.setText("A");

        jButton3.setText("B");

        jButton4.setText("C");

        jButton5.setText("D");

        jButton6.setText("E");

        jButton7.setText("F");

        jButton8.setText("G");

        jButton9.setText("H");

        jButton10.setText("I");

        jButton11.setText("J");

        jButton12.setText("K");

        jButton13.setText("L");

        jButton14.setText("M");

        jButton15.setText("N");

        jButton16.setText("O");

        jButton17.setText("P");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setText("Q");

        jButton19.setText("R");

        jButton20.setText("S");

        jButton21.setText("T");

        jButton22.setText("U");

        jButton23.setText("V");

        jButton24.setText("W");

        jButton25.setText("X");

        jButton26.setText("Y");

        jButton27.setText("Z");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButton9)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton4)
                                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton5)
                                    .addComponent(jButton12))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton6)
                                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jButton14))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton7))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton16)
                                .addGap(18, 18, 18)
                                .addComponent(jButton17)
                                .addGap(18, 18, 18)
                                .addComponent(jButton18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton19)
                                .addGap(18, 18, 18)
                                .addComponent(jButton20)
                                .addGap(18, 18, 18)
                                .addComponent(jButton21))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton23)
                                .addGap(18, 18, 18)
                                .addComponent(jButton24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton25)
                                .addGap(18, 18, 18)
                                .addComponent(jButton26)
                                .addGap(18, 18, 18)
                                .addComponent(jButton27)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton15)
                            .addComponent(jButton22)
                            .addComponent(jButton8)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReiniciar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                                    .addComponent(txtPalabra))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(btnReiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4)
                            .addComponent(jButton5)
                            .addComponent(jButton6)
                            .addComponent(jButton7)
                            .addComponent(jButton8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton9)
                            .addComponent(jButton10)
                            .addComponent(jButton11)
                            .addComponent(jButton12)
                            .addComponent(jButton13)
                            .addComponent(jButton14)
                            .addComponent(jButton15)))
                    .addComponent(btnExit))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton16)
                    .addComponent(jButton17)
                    .addComponent(jButton18)
                    .addComponent(jButton19)
                    .addComponent(jButton20)
                    .addComponent(jButton21)
                    .addComponent(jButton22))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton23)
                    .addComponent(jButton24)
                    .addComponent(jButton25)
                    .addComponent(jButton26)
                    .addComponent(jButton27))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        if (evt.getSource() == btnExit) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        // TODO add your handling code here:
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Salir.gif")));
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        // TODO add your handling code here:
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exitsinanimacion.png")));
    }//GEN-LAST:event_btnExitMouseExited

    private void txtDescripcionAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtDescripcionAncestorAdded
        // TODO add your handling code here:
        

    }//GEN-LAST:event_txtDescripcionAncestorAdded

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        // TODO add your handling code here:
        iniciar();
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JuegoAhorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JuegoAhorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JuegoAhorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JuegoAhorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JuegoAhorcado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbaImage;
    private javax.swing.JLabel lbaIntentos;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtPalabra;
    // End of variables declaration//GEN-END:variables
}
