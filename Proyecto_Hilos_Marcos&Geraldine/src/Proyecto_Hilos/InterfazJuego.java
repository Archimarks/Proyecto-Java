package Proyecto_Hilos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.border.Border;

/**
 * @author Marcos Alejandro Collazos Marmolejo and Geraldine Perilla Valderrama
 */
public class InterfazJuego extends JFrame {

    JFrame menu, juego, configuraciones, resultado, salida;
    JPanel panel_menu, panel_menu_Bottones,
            panelInstrucciones,
            panelJuegoCompleto, panel_juego, panel_juego_inf, panel_juego_sup,
            panel_juego_inf1, panel_juego_inf2,
            panel_configuracio_presentacion, panelConfiguraciones, PanelConfArriba, PanelConfAbajo,
            panel_resultados_confi,
            panel_resultados_presentacion, panel_resultados_text;
    JButton jugarButtonM, confiButtonM, salirButtonM, IniciarJuego, instRegresar,
            juegoNuevoButtonM, VolverButtonM, TerminarButtonM,
            salirButtonC, configButtonJ, salirButtonR, jugarOpcion;
    JProgressBar tiempo_faltanteJP;
    JSlider sliderT;
    JComboBox seletV, seletC, seletM;
    JLabel Label_titulo, labelTiempo, labelVelocidad, labelCanAviones, labelMaxError, num_oportunidadesoJT, num_aciertoJT, tiempoJ, puntoJ,
            resultado_oct, cant_errores, cant_aciertos, tiempo_utilizado, labelInstruc, labelSalida;

    Border blackline = BorderFactory.createLineBorder(Color.black);
    String[] OpcionesVelocidad = {" -Selecionar-", " 0.5", " 1", " 1.5"};
    String[] OpcionesCantAviones = {" -Selecionar-", " 5", " 7", " 9"};
    String[] OpcionesMaxErorr = {" -Selecionar-", " 3", " 5", " 7"};
    ImageIcon icono = null, titulo, imSalida, fondoInstruc;

    InterfazJuego() {
        Menu();
        Juego();
        Configuracion();
        Resultados();
        salida();

        menu.setVisible(true);
    }
    
    public ImageIcon iconos(int numIcono) {
        switch (numIcono) {
            case 1:
                //Jugar
                icono = new ImageIcon("src\\Iconos\\play-1.png");
                break;
            case 2:
                //Configuracion
                icono = new ImageIcon("src\\Iconos\\configuracion-2.png");
                break;
            case 3:
                //Salir
                icono = new ImageIcon("src\\Iconos\\cerrar-3.png");
                break;
            case 4:
                //Atras
                icono = new ImageIcon("src\\Iconos\\atras-4.png");
                break;
            case 5:
                //Jugar de nuevo
                icono = new ImageIcon("src\\Iconos\\jugar-de-nuevo-5.png");
                break;
            case 6:
                //Terminar
                icono = new ImageIcon("src\\Iconos\\finalizando-6.png");
                break;
        }
        return icono;
    }

    public void Menu() {
        //Menu --> 1.JFrame que se presenta
        menu = new JFrame("Principal");
        menu.setSize(500, 400);
        menu.setLayout(null);
        menu.setLocationRelativeTo(null);
        menu.setResizable(false);
        menu.getContentPane().setBackground(new Color(32, 178, 170));
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Panel
        panel_menu = new JPanel();
        panel_menu.setLayout(null);
        panel_menu.setBounds(5, 5, 485, 360);
        panel_menu.setBackground(new Color(173, 216, 230));
        menu.add(panel_menu);

        titulo = new ImageIcon("src\\Fondos\\Titulo-Juego-Hilos.png");
        Label_titulo = new JLabel(titulo);
        Label_titulo.setLayout(null);
        Label_titulo.setBounds(15, 20, 450, 200);
        Label_titulo.setIcon(new ImageIcon(titulo.getImage().getScaledInstance(Label_titulo.getWidth(), Label_titulo.getHeight(), Image.SCALE_SMOOTH)));
        Label_titulo.setBackground(new Color(0, 0, 0));
        panel_menu.add(Label_titulo);

        panel_menu_Bottones = new JPanel();
        panel_menu_Bottones.setBounds(95, 250, 300, 80);
        panel_menu_Bottones.setLayout(new GridLayout(1, 3, 30, 30));
        panel_menu_Bottones.setBackground(null);
        panel_menu.add(panel_menu_Bottones);

        jugarButtonM = new JButton(iconos(1));
        jugarButtonM.setSize(80, 80);
        jugarButtonM.setBackground(null);
        jugarButtonM.setBorder(null);
        jugarButtonM.setIcon(new ImageIcon(icono.getImage().getScaledInstance(jugarButtonM.getWidth(), jugarButtonM.getHeight(), Image.SCALE_SMOOTH)));
        jugarButtonM.addActionListener((e) -> {
            menu.setVisible(false);
            juego.setVisible(true);
            panelJuegoCompleto.setVisible(false);
            panelInstrucciones.setVisible(true);

        });
        panel_menu_Bottones.add(jugarButtonM);

        confiButtonM = new JButton(iconos(2));
        confiButtonM.setSize(80, 80);
        confiButtonM.setBackground(null);
        confiButtonM.setBorder(null);
        confiButtonM.setIcon(new ImageIcon(icono.getImage().getScaledInstance(confiButtonM.getWidth(), confiButtonM.getHeight(), Image.SCALE_SMOOTH)));
        confiButtonM.addActionListener((e) -> {
            configuraciones.setVisible(true);
            menu.setVisible(false);
        });
        panel_menu_Bottones.add(confiButtonM);

        salirButtonM = new JButton(iconos(3));
        salirButtonM.setSize(80, 80);
        salirButtonM.setBackground(null);
        salirButtonM.setBorder(null);
        salirButtonM.setIcon(new ImageIcon(icono.getImage().getScaledInstance(salirButtonM.getWidth(), salirButtonM.getHeight(), Image.SCALE_SMOOTH)));
        salirButtonM.addActionListener((e) -> {
            salida.setVisible(true);
            menu.setVisible(false);
        });
        panel_menu_Bottones.add(salirButtonM);
    }

    public void Juego() {
        //Juego --> 2.JFrame que se presenta y es donde va el juego
        juego = new JFrame("juego");
        juego.setSize(1000, 700);
        juego.setLayout(null);
        juego.setLocationRelativeTo(null);
        juego.setResizable(false);
        juego.getContentPane().setBackground(new Color(32, 178, 170));
        juego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Panel instrucciones del juego
        panelInstrucciones = new JPanel();
        panelInstrucciones.setLayout(null);
        panelInstrucciones.setBounds(50, 50, 890, 570);
        panelInstrucciones.setBackground(new Color(173, 216, 230));
        juego.add(panelInstrucciones);

        fondoInstruc = new ImageIcon("src\\Fondos\\Fondo-instruc.png");
        labelInstruc = new JLabel(fondoInstruc);
        labelInstruc.setLayout(null);
        labelInstruc.setBounds(0, 0, 890, 570);
        labelInstruc.setIcon(new ImageIcon(fondoInstruc.getImage().getScaledInstance(labelInstruc.getWidth(), labelInstruc.getHeight(), Image.SCALE_SMOOTH)));
        labelInstruc.setBackground(null);
        panelInstrucciones.add(labelInstruc);

        instRegresar = new JButton(iconos(4));
        instRegresar.setBounds(740, 490, 60, 60);
        instRegresar.setBackground(null);
        instRegresar.setBorder(null);
        instRegresar.setIcon(new ImageIcon(icono.getImage().getScaledInstance(instRegresar.getWidth(), instRegresar.getHeight(), Image.SCALE_SMOOTH)));
        instRegresar.addActionListener((e) -> {
            menu.setVisible(true);
            juego.setVisible(false);
        });
        labelInstruc.add(instRegresar);

        IniciarJuego = new JButton(iconos(1));
        IniciarJuego.setBounds(810, 490, 60, 60);
        IniciarJuego.setBackground(null);
        IniciarJuego.setBorder(null);
        IniciarJuego.setIcon(new ImageIcon(icono.getImage().getScaledInstance(IniciarJuego.getWidth(), IniciarJuego.getHeight(), Image.SCALE_SMOOTH)));
        IniciarJuego.addActionListener((e) -> {
            panelJuegoCompleto.setVisible(true);
            panelInstrucciones.setVisible(false);
        });
        labelInstruc.add(IniciarJuego);

        //Panel juego
        panelJuegoCompleto = new JPanel();
        panelJuegoCompleto.setLayout(null);
        panelJuegoCompleto.setBounds(0, 0, 1000, 700);
        panelJuegoCompleto.setBackground(null);
        panelJuegoCompleto.setVisible(false);
        juego.add(panelJuegoCompleto);

        //Panel superior
        panel_juego_sup = new JPanel();
        panel_juego_sup.setLayout(null);
        panel_juego_sup.setBounds(0, 0, 1000, 70);
        panel_juego_sup.setBackground(new Color(173, 216, 230));
        panelJuegoCompleto.add(panel_juego_sup);

        tiempoJ = new JLabel("");
        tiempoJ.setName("Tiempo");
        tiempoJ.setOpaque(true);
        tiempoJ.setBackground(Color.WHITE);
        tiempoJ.setBounds(30, 20, 100, 30);
        panel_juego_sup.add(tiempoJ);

        tiempo_faltanteJP = new JProgressBar();
        tiempo_faltanteJP.setBorder(null);
        tiempo_faltanteJP.setForeground(new Color(135, 206, 235));
        tiempo_faltanteJP.setBounds(160, 20, 670, 30);
        tiempo_faltanteJP.setValue(100);
        tiempo_faltanteJP.addChangeListener((e) -> {
        });
        panel_juego_sup.add(tiempo_faltanteJP);

        puntoJ = new JLabel("");
        puntoJ.setOpaque(true);
        puntoJ.setBackground(Color.WHITE);
        puntoJ.setName("Puntos");
        puntoJ.setBounds(860, 20, 100, 30);
        panel_juego_sup.add(puntoJ);

        //Panel del juego
        panel_juego = new JPanel();
        panel_juego.setLayout(null);
        panel_juego.setBounds(0, 70, 1000, 520);
        panel_juego.setBackground(new Color(173, 216, 230));
        panelJuegoCompleto.add(panel_juego);

        //Panel inferior
        panel_juego_inf = new JPanel();
        panel_juego_inf.setLayout(null);
        panel_juego_inf.setBounds(0, 590, 1000, 80);
        panel_juego_inf.setBackground(new Color(107, 142, 35));
        panelJuegoCompleto.add(panel_juego_inf);

        panel_juego_inf1 = new JPanel();
        panel_juego_inf1.setLayout(new GridLayout(1, 0, 20, 0));
        panel_juego_inf1.setBounds(20, 20, 350, 40);
        panel_juego_inf1.setBackground(null);
        panel_juego_inf.add(panel_juego_inf1);

        num_oportunidadesoJT = new JLabel(" Oportunidades: ");
        num_oportunidadesoJT.setOpaque(true);
        num_oportunidadesoJT.setBackground(Color.WHITE);
        num_oportunidadesoJT.setFont(new Font("Arial", Font.BOLD, 14));
        num_oportunidadesoJT.setName("Oportunidades");
        panel_juego_inf1.add(num_oportunidadesoJT);

        num_aciertoJT = new JLabel(" Aciertos: ");
        num_aciertoJT.setOpaque(true);
        num_aciertoJT.setBackground(Color.WHITE);
        num_aciertoJT.setFont(new Font("Arial", Font.BOLD, 14));
        num_aciertoJT.setName("Aciertos");
        panel_juego_inf1.add(num_aciertoJT);

        //Panel botones del juego
        panel_juego_inf2 = new JPanel();
        panel_juego_inf2.setLayout(new GridLayout(1, 4, 20, 20));
        panel_juego_inf2.setBounds(690, 15, 280, 55);
        panel_juego_inf2.setBackground(null);
        panel_juego_inf.add(panel_juego_inf2);

        configButtonJ = new JButton(iconos(2));
        configButtonJ.setSize(55, 55);
        configButtonJ.setBackground(null);
        configButtonJ.setBorder(null);
        configButtonJ.setIcon(new ImageIcon(icono.getImage().getScaledInstance(configButtonJ.getWidth(), configButtonJ.getHeight(), Image.SCALE_SMOOTH)));
        configButtonJ.addActionListener((e) -> {
            configuraciones.setVisible(true);
            juego.setVisible(false);
        });
        panel_juego_inf2.add(configButtonJ);

        juegoNuevoButtonM = new JButton(iconos(5));
        juegoNuevoButtonM.setSize(55, 55);
        juegoNuevoButtonM.setBackground(null);
        juegoNuevoButtonM.setBorder(null);
        juegoNuevoButtonM.setIcon(new ImageIcon(icono.getImage().getScaledInstance(juegoNuevoButtonM.getWidth(), juegoNuevoButtonM.getHeight(), Image.SCALE_SMOOTH)));
        juegoNuevoButtonM.addActionListener((e) -> {
        });
        panel_juego_inf2.add(juegoNuevoButtonM);

        VolverButtonM = new JButton(iconos(4));
        VolverButtonM.setSize(55, 55);
        VolverButtonM.setBackground(null);
        VolverButtonM.setBorder(null);
        VolverButtonM.setIcon(new ImageIcon(icono.getImage().getScaledInstance(VolverButtonM.getWidth(), VolverButtonM.getHeight(), Image.SCALE_SMOOTH)));
        VolverButtonM.addActionListener((e) -> {
            menu.setVisible(true);
            juego.setVisible(false);

        });
        panel_juego_inf2.add(VolverButtonM);

        TerminarButtonM = new JButton(iconos(6));
        TerminarButtonM.setSize(55, 55);
        TerminarButtonM.setBackground(null);
        TerminarButtonM.setBorder(null);
        TerminarButtonM.setIcon(new ImageIcon(icono.getImage().getScaledInstance(TerminarButtonM.getWidth(), TerminarButtonM.getHeight(), Image.SCALE_SMOOTH)));
        TerminarButtonM.addActionListener((e) -> {
            juego.setVisible(false);
            resultado.setVisible(true);

        });
        panel_juego_inf2.add(TerminarButtonM);

    }

    public void Configuracion() {
        //Configuracion -> Configuraciones del juego
        configuraciones = new JFrame("Configuraciones");
        configuraciones.setSize(500, 450);
        configuraciones.setLayout(null);
        configuraciones.setLocationRelativeTo(null);
        configuraciones.setResizable(false);
        configuraciones.getContentPane().setBackground(new Color(173, 216, 230));
        configuraciones.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel_configuracio_presentacion = new JPanel();
        panel_configuracio_presentacion.setLayout(null);
        panel_configuracio_presentacion.setBounds(70, 20, 335, 80);
        panel_configuracio_presentacion.setBackground(new Color(0, 0, 0));
        configuraciones.add(panel_configuracio_presentacion);

        panelConfiguraciones = new JPanel();
        panelConfiguraciones.setLayout(new GridLayout(2, 1, 10, 10));
        panelConfiguraciones.setBounds(20, 120, 455, 240);
        panelConfiguraciones.setBackground(null);
        configuraciones.add(panelConfiguraciones);

        PanelConfArriba = new JPanel();
        PanelConfArriba.setLayout(null);
        PanelConfArriba.setBackground(null);
        panelConfiguraciones.add(PanelConfArriba);

        PanelConfAbajo = new JPanel();
        PanelConfAbajo.setLayout(null);
        PanelConfAbajo.setBackground(null);
        panelConfiguraciones.add(PanelConfAbajo);

        sliderT = new JSlider(0, 20, 60, 20);
        sliderT.setBounds(10, 60, 220, 60);
        sliderT.setBackground(Color.WHITE);
        sliderT.setMajorTickSpacing(5);
        sliderT.setMinorTickSpacing(10);
        sliderT.setPaintLabels(true);
        sliderT.setPaintTicks(true);
        sliderT.setPaintTrack(true);
        sliderT.addChangeListener((e) -> {
            labelTiempo.setText("Tiempo: " + sliderT.getValue() + " s");
        });
        PanelConfArriba.add(sliderT);

        labelTiempo = new JLabel("Tiempo: " + sliderT.getValue() + " s");
        labelTiempo.setBounds(20, 10, 200, 40);
        labelTiempo.setFont(new Font("Arial", Font.BOLD, 16));
        labelTiempo.setHorizontalAlignment(JLabel.CENTER);
        labelTiempo.setForeground(Color.BLACK);
        labelTiempo.setOpaque(true);
        labelTiempo.setBackground(new Color(240, 248, 255));
        labelTiempo.setBorder(blackline);
        PanelConfArriba.add(labelTiempo);

        labelVelocidad = new JLabel("Velocidad: (s)");
        labelVelocidad.setBounds(265, 10, 170, 40);
        labelVelocidad.setFont(new Font("Arial", Font.BOLD, 16));
        labelVelocidad.setHorizontalAlignment(JLabel.CENTER);
        labelVelocidad.setForeground(Color.BLACK);
        labelVelocidad.setOpaque(true);
        labelVelocidad.setBackground(new Color(240, 248, 255));
        labelVelocidad.setBorder(blackline);
        PanelConfArriba.add(labelVelocidad);

        seletV = new JComboBox(OpcionesVelocidad);
        seletV.setBounds(265, 60, 170, 40);
        seletV.setBackground(Color.WHITE);
        seletV.setFont(new Font("Arial", Font.PLAIN, 16));
        seletV.addItemListener((e) -> {
        });
        PanelConfArriba.add(seletV);

        labelCanAviones = new JLabel("Cantidad de Aviones:");
        labelCanAviones.setBounds(20, 10, 200, 40);
        labelCanAviones.setFont(new Font("Arial", Font.BOLD, 16));
        labelCanAviones.setHorizontalAlignment(JLabel.CENTER);
        labelCanAviones.setForeground(Color.BLACK);
        labelCanAviones.setOpaque(true);
        labelCanAviones.setBackground(new Color(240, 248, 255));
        labelCanAviones.setBorder(blackline);
        PanelConfAbajo.add(labelCanAviones);

        seletC = new JComboBox(OpcionesCantAviones);
        seletC.setBackground(Color.WHITE);
        seletC.setFont(new Font("Arial", Font.PLAIN, 16));
        seletC.setBounds(20, 60, 200, 40);
        seletC.addItemListener((e) -> {
        });
        PanelConfAbajo.add(seletC);

        labelMaxError = new JLabel("Máximo de errores:");
        labelMaxError.setBounds(265, 10, 170, 40);
        labelMaxError.setFont(new Font("Arial", Font.BOLD, 16));
        labelMaxError.setHorizontalAlignment(JLabel.CENTER);
        labelMaxError.setForeground(Color.BLACK);
        labelMaxError.setOpaque(true);
        labelMaxError.setBackground(new Color(240, 248, 255));
        labelMaxError.setBorder(blackline);
        PanelConfAbajo.add(labelMaxError);

        seletM = new JComboBox(OpcionesMaxErorr);
        seletM.setBackground(Color.WHITE);
        seletM.setFont(new Font("Arial", Font.PLAIN, 16));
        seletM.setBounds(265, 60, 170, 40);
        seletM.addItemListener((e) -> {
        });
        PanelConfAbajo.add(seletM);

        jugarOpcion = new JButton(iconos(1));
        jugarOpcion.setBounds(200, 360, 50, 50);
        jugarOpcion.setBackground(null);
        jugarOpcion.setBorder(null);
        jugarOpcion.setIcon(new ImageIcon(icono.getImage().getScaledInstance(jugarOpcion.getWidth(), jugarOpcion.getHeight(), Image.SCALE_SMOOTH)));
        jugarOpcion.addActionListener((e) -> {
            configuraciones.setVisible(false);
            juego.setVisible(true);
            panelJuegoCompleto.setVisible(false);
            panelInstrucciones.setVisible(true);
        });
        configuraciones.add(jugarOpcion);

        salirButtonC = new JButton(iconos(4));
        salirButtonC.setBounds(270, 360, 50, 50);
        salirButtonC.setBackground(null);
        salirButtonC.setBorder(null);
        salirButtonC.setIcon(new ImageIcon(icono.getImage().getScaledInstance(salirButtonC.getWidth(), salirButtonC.getHeight(), Image.SCALE_SMOOTH)));
        salirButtonC.addActionListener((e) -> {
            menu.setVisible(true);
            configuraciones.setVisible(false);
        });
        configuraciones.add(salirButtonC);

    }

    public void Resultados() {
        //Resultados -> se muestran los resultados del juego, al finalizar
        resultado = new JFrame("Resultados");
        resultado.setSize(500, 400);
        resultado.setLayout(null);
        resultado.setLocationRelativeTo(null);
        resultado.setResizable(false);
        resultado.getContentPane().setBackground(new Color(173, 216, 230));
        resultado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel_resultados_presentacion = new JPanel();
        panel_resultados_presentacion.setLayout(null);
        panel_resultados_presentacion.setBounds(70, 20, 335, 80);
        panel_resultados_presentacion.setBackground(new Color(0, 0, 0));
        resultado.add(panel_resultados_presentacion);

        panel_resultados_text = new JPanel();
        panel_resultados_text.setLayout(new GridLayout(0, 1, 0, 20));
        panel_resultados_text.setBounds(135, 120, 220, 200);
        panel_resultados_text.setBackground(null);
        resultado.add(panel_resultados_text);

        resultado_oct = new JLabel(" Cantidad de Errores: ");
        resultado_oct.setOpaque(true);
        resultado_oct.setBackground(Color.WHITE);
        resultado_oct.setFont(new Font("Arial", Font.BOLD, 16));
        panel_resultados_text.add(resultado_oct);

        cant_aciertos = new JLabel(" Cantidad de Aciertos: ");
        cant_aciertos.setOpaque(true);
        cant_aciertos.setBackground(Color.WHITE);
        cant_aciertos.setFont(new Font("Arial", Font.BOLD, 16));
        panel_resultados_text.add(cant_aciertos);

        tiempo_utilizado = new JLabel(" Tiempo utilizado: ");
        tiempo_utilizado.setOpaque(true);
        tiempo_utilizado.setBackground(Color.WHITE);
        tiempo_utilizado.setFont(new Font("Arial", Font.BOLD, 16));
        panel_resultados_text.add(tiempo_utilizado);

        salirButtonR = new JButton(iconos(3));
        salirButtonR.setBounds(420, 300, 60, 60);
        salirButtonR.setBackground(null);
        salirButtonR.setBorder(null);
        salirButtonR.setIcon(new ImageIcon(icono.getImage().getScaledInstance(salirButtonR.getWidth(), salirButtonR.getHeight(), Image.SCALE_SMOOTH)));
        salirButtonR.addActionListener((e) -> {
            resultado.setVisible(false);
            menu.setVisible(true);
        });
        resultado.add(salirButtonR);

    }
    
    public void salida(){
        salida = new JFrame("Salida");
        salida.setSize(500, 400);
        salida.setLayout(null);
        salida.setLocationRelativeTo(null);
        salida.setResizable(false);
        salida.getContentPane().setBackground(new Color(173, 216, 230));
        salida.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        imSalida = new ImageIcon("src\\Fondos\\Fondo-salida.png");
        labelSalida = new JLabel(titulo);
        labelSalida.setLayout(null);
        labelSalida.setBounds(0, 0, 500, 373);
        labelSalida.setIcon(new ImageIcon(imSalida.getImage().getScaledInstance(labelSalida.getWidth(), labelSalida.getHeight(), Image.SCALE_SMOOTH)));
        labelSalida.setBackground(new Color(0, 0, 0));
        salida.add(labelSalida);
        
        setVisible(false);
    }

}
