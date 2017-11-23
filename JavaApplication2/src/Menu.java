
import javafx.scene.paint.Color;
import java.awt.Color.*;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mauri_000
 */
public class Menu extends javax.swing.JFrame {
    //sIMPLEX
    double Matriz[][] = null;
    int restricciones = 0, variables = 0, iter = 0, iteracion = 0;
    Object array[] = null;
    Object EtiquetaX[] = null, EtiquetaY[] = null;
    
    
    void ocultaSimplex(){
        this.btnSMaximizarr.setVisible(false);
        this.btnSMinimizar.setVisible(false);
        this.simplex_max.setVisible(false);
        this.Simplex_Min.setVisible(false);
        
    }
    
    
    
    public int ColumnaPivote() {
        int pos = 0;
        double aux = Matriz[restricciones][0];
        for (int i = 1; i < restricciones + variables; i++) {
            if (aux > Matriz[restricciones][i]) {
                aux = Matriz[restricciones][i];
                pos = i;
            }
        }
        return pos;
    }

    public int FilaPivote() {
        int columna = ColumnaPivote();
        double temp = 0, razon = Matriz[0][variables + restricciones] / Matriz[0][columna];
        int pos = 0;
        for (int i = 1; i < restricciones; i++) {
            if (Matriz[i][columna] != 0) {
                temp = Matriz[i][variables + restricciones] / Matriz[i][columna];
                if (razon > temp && temp >= 0) {
                    razon = temp;
                    pos = i;
                }
            }

        }
        return pos;
    }

    public void NuevaTabla(int Fila, int Columna) {
        double pivote = Matriz[Fila][Columna], temp = 0;//--
        for (int i = 0; i < restricciones + variables + 1; i++) {
            Matriz[Fila][i] = Matriz[Fila][i] / pivote;
        }
        for (int i = 0; i < restricciones + 1; i++) {
            temp = Matriz[i][Columna];
            for (int j = 0; j < variables + restricciones + 1; j++) {
                if (i != Fila) {
                    Matriz[i][j] = Matriz[i][j] - temp * Matriz[Fila][j];
                } else {
                    break;
                }
            }
        }
    }

    public boolean ComprobarResultado() {
        boolean result = true;
        for (int i = 0; i < restricciones + variables; i++) {
            if (Matriz[restricciones][i] < 0) {
                result = false;
                break;
            }
        }
        return result;
    }
    
    //MIIIIINIMIZACION
    double[][] MatrizMin = null;
    int restriccionesMin = 0, variablesMin = 0, iterMin = 0, iteracionMin = 0;
    Object[] arrayMin = null;
    Object EtiquetaXMin[] = null, EtiquetaYMin[] = null;
    public int FilaPivoteMin() {
        int pos = 0;
        double temp = 0, aux = 0;
        for (int i = 0; i < restriccionesMin; i++) {
            temp = MatrizMin[i][variablesMin + restriccionesMin];
            if (temp < aux) {
                aux = temp;
                pos = i;
            }
        }
        return pos;
    }

    public int ColumnaPivoteMin() {
        int pos = 0, fila = FilaPivoteMin();
        double temp = 0, razon = -1000;
        for (int i = 0; i < variablesMin + restriccionesMin; i++) {
            if (MatrizMin[fila][i] != 0) {
                temp = MatrizMin[restriccionesMin][i] / MatrizMin[fila][i];
                if (temp > razon && temp < 0) {
                    razon = temp;
                    pos = i;
                }
            }
        }
        return pos;
    }

    public void NuevaTablaMin(int Fila, int Columna) {
        double pivote = MatrizMin[Fila][Columna], temp = 0;//--
        for (int i = 0; i < restriccionesMin + variablesMin + 1; i++) {
            MatrizMin[Fila][i] = MatrizMin[Fila][i] / pivote;
        }
        for (int i = 0; i < restriccionesMin + 1; i++) {
            temp = MatrizMin[i][Columna];
            for (int j = 0; j < variablesMin + restriccionesMin + 1; j++) {
                if (i != Fila) {
                    MatrizMin[i][j] = MatrizMin[i][j] - temp * MatrizMin[Fila][j];
                } else {
                    break;
                }
            }
        }
    }

    public boolean ComprobarResultadoMin() {
        boolean result = true;
        for (int i = 0; i < restriccionesMin; i++) {
            if (MatrizMin[i][restriccionesMin + variablesMin] < 0) {
                result = false;
                break;
            }
        }
        return result;
    }
    
    // FIN SIMPLEX

    /**
     * Creates new form Menu
     */
    public Menu() { 
        
        this.getContentPane().setBackground(new java.awt.Color(29,20,43));
        initComponents();
        try {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        this.Simplex.setVisible(false);
        this.simplex_max.setVisible(false);
        this.Simplex_Min.setVisible(false);
        
        this.panelTablaSim1.setVisible(false);
        this.panelTablaSimMIN.setVisible(true);
        this.TransporteF.setVisible(false);
        this.setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        btnSimplex = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnTransporte = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnInventarios = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnEspera = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Simplex = new javax.swing.JPanel();
        btnSMinimizar = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnSMaximizarr = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        simplex_max = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        txtRestriccionMax = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        txtVariableMax = new javax.swing.JTextField();
        btnSimAceptar = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        panelTablaSim1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSolucion = new javax.swing.JTable();
        btnSolucion = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        btnSolucion1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        Simplex_Min = new javax.swing.JPanel();
        simplex_max1 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        txtRestriccionMin = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        txtVariableMin = new javax.swing.JTextField();
        btnSimAceptar1 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        panelTablaSimMIN = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1Min = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableSolucionMin = new javax.swing.JTable();
        btnSolucionMin = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        btnSolucion1Min = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        TransporteF = new javax.swing.JPanel();
        txtNro_Origen = new javax.swing.JTextField();
        txtNro_Destino = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnSalir = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Programación Lineal");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(8, 6, 24));
        setIconImage(getIconImage());
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(29, 20, 43));

        btnSimplex.setBackground(new java.awt.Color(29, 20, 43));
        btnSimplex.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSimplexMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSimplexMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSimplexMouseExited(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/simpl.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Lao UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Simplex");

        javax.swing.GroupLayout btnSimplexLayout = new javax.swing.GroupLayout(btnSimplex);
        btnSimplex.setLayout(btnSimplexLayout);
        btnSimplexLayout.setHorizontalGroup(
            btnSimplexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSimplexLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnSimplexLayout.setVerticalGroup(
            btnSimplexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSimplexLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnSimplexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnTransporte.setBackground(new java.awt.Color(29, 20, 43));
        btnTransporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTransporteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTransporteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTransporteMouseExited(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trnasp.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Lao UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Transporte");

        javax.swing.GroupLayout btnTransporteLayout = new javax.swing.GroupLayout(btnTransporte);
        btnTransporte.setLayout(btnTransporteLayout);
        btnTransporteLayout.setHorizontalGroup(
            btnTransporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTransporteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(19, 19, 19)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnTransporteLayout.setVerticalGroup(
            btnTransporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTransporteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnTransporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnInventarios.setBackground(new java.awt.Color(29, 20, 43));
        btnInventarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInventariosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInventariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInventariosMouseExited(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/invent.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Lao UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Inventario");

        javax.swing.GroupLayout btnInventariosLayout = new javax.swing.GroupLayout(btnInventarios);
        btnInventarios.setLayout(btnInventariosLayout);
        btnInventariosLayout.setHorizontalGroup(
            btnInventariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnInventariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnInventariosLayout.setVerticalGroup(
            btnInventariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnInventariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnInventariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnEspera.setBackground(new java.awt.Color(29, 20, 43));
        btnEspera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEsperaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEsperaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEsperaMouseExited(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Espera.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Lao UI", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Lineas de Espera");

        javax.swing.GroupLayout btnEsperaLayout = new javax.swing.GroupLayout(btnEspera);
        btnEspera.setLayout(btnEsperaLayout);
        btnEsperaLayout.setHorizontalGroup(
            btnEsperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEsperaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnEsperaLayout.setVerticalGroup(
            btnEsperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEsperaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnEsperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(29, 20, 43));

        jLabel9.setFont(new java.awt.Font("Lao UI", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Programacion");

        jLabel10.setFont(new java.awt.Font("Lao UI", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Lineal");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Icono.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSimplex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnTransporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnInventarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnEspera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSimplex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInventarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEspera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Simplex.setBackground(new java.awt.Color(29, 20, 43));

        btnSMinimizar.setBackground(new java.awt.Color(29, 20, 43));
        btnSMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSMinimizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSMinimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSMinimizarMouseExited(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Min.png"))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Lao UI", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Minimizar");

        javax.swing.GroupLayout btnSMinimizarLayout = new javax.swing.GroupLayout(btnSMinimizar);
        btnSMinimizar.setLayout(btnSMinimizarLayout);
        btnSMinimizarLayout.setHorizontalGroup(
            btnSMinimizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSMinimizarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnSMinimizarLayout.setVerticalGroup(
            btnSMinimizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSMinimizarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnSMinimizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnSMaximizarr.setBackground(new java.awt.Color(29, 20, 43));
        btnSMaximizarr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSMaximizarrMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSMaximizarrMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSMaximizarrMouseExited(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Max.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Lao UI", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Maximizar");

        javax.swing.GroupLayout btnSMaximizarrLayout = new javax.swing.GroupLayout(btnSMaximizarr);
        btnSMaximizarr.setLayout(btnSMaximizarrLayout);
        btnSMaximizarrLayout.setHorizontalGroup(
            btnSMaximizarrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSMaximizarrLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
            .addGroup(btnSMaximizarrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSMaximizarrLayout.createSequentialGroup()
                    .addContainerGap(76, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)))
        );
        btnSMaximizarrLayout.setVerticalGroup(
            btnSMaximizarrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSMaximizarrLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(btnSMaximizarrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnSMaximizarrLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        simplex_max.setBackground(new java.awt.Color(29, 20, 43));

        jLabel16.setFont(new java.awt.Font("Lao UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("No. Restricciones");

        txtRestriccionMax.setBackground(new java.awt.Color(29, 20, 43));
        txtRestriccionMax.setFont(new java.awt.Font("Lao UI", 1, 14)); // NOI18N
        txtRestriccionMax.setForeground(new java.awt.Color(255, 255, 255));
        txtRestriccionMax.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRestriccionMax.setToolTipText("Numero de restricciones");
        txtRestriccionMax.setBorder(null);
        txtRestriccionMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRestriccionMaxActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Lao UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("No. Variables");
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtVariableMax.setBackground(new java.awt.Color(29, 20, 43));
        txtVariableMax.setFont(new java.awt.Font("Lao UI", 1, 14)); // NOI18N
        txtVariableMax.setForeground(new java.awt.Color(255, 255, 255));
        txtVariableMax.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtVariableMax.setToolTipText("Numero de restricciones");
        txtVariableMax.setBorder(null);

        btnSimAceptar.setBackground(new java.awt.Color(29, 20, 43));
        btnSimAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSimAceptarMouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Lao UI", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Aceptar");

        javax.swing.GroupLayout btnSimAceptarLayout = new javax.swing.GroupLayout(btnSimAceptar);
        btnSimAceptar.setLayout(btnSimAceptarLayout);
        btnSimAceptarLayout.setHorizontalGroup(
            btnSimAceptarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSimAceptarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(16, 16, 16))
        );
        btnSimAceptarLayout.setVerticalGroup(
            btnSimAceptarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSimAceptarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelTablaSim1.setBackground(new java.awt.Color(29, 20, 43));

        jTable1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTable1.setFont(new java.awt.Font("Lao UI", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(44, 31, 65));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "                X1", "                X2", "                X3", "                X4"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setIntercellSpacing(new java.awt.Dimension(3, 3));
        jTable1.setOpaque(false);
        jTable1.setRowSelectionAllowed(false);
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel15.setFont(new java.awt.Font("Lao UI", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Tabla simplex Maximización");

        jTableSolucion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTableSolucion.setFont(new java.awt.Font("Lao UI", 0, 14)); // NOI18N
        jTableSolucion.setForeground(new java.awt.Color(44, 31, 65));
        jTableSolucion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "                X1", "                X2", "                X3", "                X4"
            }
        ));
        jTableSolucion.setGridColor(new java.awt.Color(255, 255, 255));
        jTableSolucion.setIntercellSpacing(new java.awt.Dimension(3, 3));
        jTableSolucion.setOpaque(false);
        jTableSolucion.setRowSelectionAllowed(false);
        jTableSolucion.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTableSolucion.setShowHorizontalLines(false);
        jTableSolucion.setShowVerticalLines(false);
        jScrollPane2.setViewportView(jTableSolucion);

        btnSolucion.setBackground(new java.awt.Color(29, 20, 43));
        btnSolucion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnSolucion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSolucionMouseClicked(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Lao UI", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Solución");
        jLabel20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout btnSolucionLayout = new javax.swing.GroupLayout(btnSolucion);
        btnSolucion.setLayout(btnSolucionLayout);
        btnSolucionLayout.setHorizontalGroup(
            btnSolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSolucionLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        btnSolucionLayout.setVerticalGroup(
            btnSolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSolucionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnSolucion1.setBackground(new java.awt.Color(29, 20, 43));
        btnSolucion1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnSolucion1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSolucion1MouseClicked(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Lao UI", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Iteración");
        jLabel21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout btnSolucion1Layout = new javax.swing.GroupLayout(btnSolucion1);
        btnSolucion1.setLayout(btnSolucion1Layout);
        btnSolucion1Layout.setHorizontalGroup(
            btnSolucion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSolucion1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        btnSolucion1Layout.setVerticalGroup(
            btnSolucion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSolucion1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelTablaSim1Layout = new javax.swing.GroupLayout(panelTablaSim1);
        panelTablaSim1.setLayout(panelTablaSim1Layout);
        panelTablaSim1Layout.setHorizontalGroup(
            panelTablaSim1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaSim1Layout.createSequentialGroup()
                .addGroup(panelTablaSim1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(panelTablaSim1Layout.createSequentialGroup()
                        .addComponent(btnSolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                        .addComponent(btnSolucion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(panelTablaSim1Layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTablaSim1Layout.setVerticalGroup(
            panelTablaSim1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaSim1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelTablaSim1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSolucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSolucion1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout simplex_maxLayout = new javax.swing.GroupLayout(simplex_max);
        simplex_max.setLayout(simplex_maxLayout);
        simplex_maxLayout.setHorizontalGroup(
            simplex_maxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(simplex_maxLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(simplex_maxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(simplex_maxLayout.createSequentialGroup()
                        .addGroup(simplex_maxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnSimAceptar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRestriccionMax, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtVariableMax, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 5, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelTablaSim1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        simplex_maxLayout.setVerticalGroup(
            simplex_maxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(simplex_maxLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRestriccionMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtVariableMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSimAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelTablaSim1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Simplex_Min.setBackground(new java.awt.Color(29, 20, 43));

        simplex_max1.setBackground(new java.awt.Color(29, 20, 43));

        jLabel22.setFont(new java.awt.Font("Lao UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("No. Restricciones");

        txtRestriccionMin.setBackground(new java.awt.Color(29, 20, 43));
        txtRestriccionMin.setFont(new java.awt.Font("Lao UI", 1, 14)); // NOI18N
        txtRestriccionMin.setForeground(new java.awt.Color(255, 255, 255));
        txtRestriccionMin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRestriccionMin.setToolTipText("Numero de restricciones");
        txtRestriccionMin.setBorder(null);
        txtRestriccionMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRestriccionMinActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Lao UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("No. Variables");
        jLabel23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtVariableMin.setBackground(new java.awt.Color(29, 20, 43));
        txtVariableMin.setFont(new java.awt.Font("Lao UI", 1, 14)); // NOI18N
        txtVariableMin.setForeground(new java.awt.Color(255, 255, 255));
        txtVariableMin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtVariableMin.setToolTipText("Numero de restricciones");
        txtVariableMin.setBorder(null);

        btnSimAceptar1.setBackground(new java.awt.Color(29, 20, 43));
        btnSimAceptar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSimAceptar1MouseClicked(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Lao UI", 0, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Aceptar");

        javax.swing.GroupLayout btnSimAceptar1Layout = new javax.swing.GroupLayout(btnSimAceptar1);
        btnSimAceptar1.setLayout(btnSimAceptar1Layout);
        btnSimAceptar1Layout.setHorizontalGroup(
            btnSimAceptar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSimAceptar1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(16, 16, 16))
        );
        btnSimAceptar1Layout.setVerticalGroup(
            btnSimAceptar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSimAceptar1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelTablaSimMIN.setBackground(new java.awt.Color(29, 20, 43));

        jTable1Min.setFont(new java.awt.Font("Lao UI", 0, 14)); // NOI18N
        jTable1Min.setForeground(new java.awt.Color(44, 31, 65));
        jTable1Min.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "                X1", "                X2", "                X3", "                X4"
            }
        ));
        jTable1Min.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1Min.setOpaque(false);
        jTable1Min.setRowSelectionAllowed(false);
        jTable1Min.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable1Min.setShowHorizontalLines(false);
        jTable1Min.setShowVerticalLines(false);
        jScrollPane3.setViewportView(jTable1Min);

        jLabel25.setFont(new java.awt.Font("Lao UI", 0, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Tabla simplex Minimización");

        jTableSolucionMin.setFont(new java.awt.Font("Lao UI", 0, 14)); // NOI18N
        jTableSolucionMin.setForeground(new java.awt.Color(44, 31, 65));
        jTableSolucionMin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "                X1", "                X2", "                X3", "                X4"
            }
        ));
        jTableSolucionMin.setGridColor(new java.awt.Color(255, 255, 255));
        jTableSolucionMin.setOpaque(false);
        jTableSolucionMin.setRowSelectionAllowed(false);
        jTableSolucionMin.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTableSolucionMin.setShowHorizontalLines(false);
        jTableSolucionMin.setShowVerticalLines(false);
        jScrollPane4.setViewportView(jTableSolucionMin);

        btnSolucionMin.setBackground(new java.awt.Color(29, 20, 43));
        btnSolucionMin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnSolucionMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSolucionMinMouseClicked(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Lao UI", 0, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Solución");
        jLabel26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout btnSolucionMinLayout = new javax.swing.GroupLayout(btnSolucionMin);
        btnSolucionMin.setLayout(btnSolucionMinLayout);
        btnSolucionMinLayout.setHorizontalGroup(
            btnSolucionMinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSolucionMinLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        btnSolucionMinLayout.setVerticalGroup(
            btnSolucionMinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSolucionMinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnSolucion1Min.setBackground(new java.awt.Color(29, 20, 43));
        btnSolucion1Min.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnSolucion1Min.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSolucion1MinMouseClicked(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Lao UI", 0, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Iteración");
        jLabel27.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout btnSolucion1MinLayout = new javax.swing.GroupLayout(btnSolucion1Min);
        btnSolucion1Min.setLayout(btnSolucion1MinLayout);
        btnSolucion1MinLayout.setHorizontalGroup(
            btnSolucion1MinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSolucion1MinLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        btnSolucion1MinLayout.setVerticalGroup(
            btnSolucion1MinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSolucion1MinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelTablaSimMINLayout = new javax.swing.GroupLayout(panelTablaSimMIN);
        panelTablaSimMIN.setLayout(panelTablaSimMINLayout);
        panelTablaSimMINLayout.setHorizontalGroup(
            panelTablaSimMINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaSimMINLayout.createSequentialGroup()
                .addGroup(panelTablaSimMINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4)
                    .addGroup(panelTablaSimMINLayout.createSequentialGroup()
                        .addComponent(btnSolucionMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                        .addComponent(btnSolucion1Min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaSimMINLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addGap(212, 212, 212))
        );
        panelTablaSimMINLayout.setVerticalGroup(
            panelTablaSimMINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaSimMINLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelTablaSimMINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSolucionMin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSolucion1Min, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout simplex_max1Layout = new javax.swing.GroupLayout(simplex_max1);
        simplex_max1.setLayout(simplex_max1Layout);
        simplex_max1Layout.setHorizontalGroup(
            simplex_max1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(simplex_max1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(simplex_max1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(simplex_max1Layout.createSequentialGroup()
                        .addGroup(simplex_max1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnSimAceptar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRestriccionMin, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtVariableMin, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 5, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelTablaSimMIN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        simplex_max1Layout.setVerticalGroup(
            simplex_max1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(simplex_max1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRestriccionMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtVariableMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSimAceptar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelTablaSimMIN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Simplex_MinLayout = new javax.swing.GroupLayout(Simplex_Min);
        Simplex_Min.setLayout(Simplex_MinLayout);
        Simplex_MinLayout.setHorizontalGroup(
            Simplex_MinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 903, Short.MAX_VALUE)
            .addGroup(Simplex_MinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Simplex_MinLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(simplex_max1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(20, Short.MAX_VALUE)))
        );
        Simplex_MinLayout.setVerticalGroup(
            Simplex_MinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
            .addGroup(Simplex_MinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Simplex_MinLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(simplex_max1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        TransporteF.setBackground(new java.awt.Color(29, 20, 43));

        txtNro_Origen.setBackground(new java.awt.Color(29, 20, 43));
        txtNro_Origen.setFont(new java.awt.Font("Lao UI", 1, 14)); // NOI18N
        txtNro_Origen.setForeground(new java.awt.Color(255, 255, 255));
        txtNro_Origen.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNro_Origen.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtNro_Destino.setBackground(new java.awt.Color(29, 20, 43));
        txtNro_Destino.setFont(new java.awt.Font("Lao UI", 1, 14)); // NOI18N
        txtNro_Destino.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNro_Destino.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel29.setFont(new java.awt.Font("Lao UI", 0, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Modelo de transporte");

        jLabel30.setFont(new java.awt.Font("Lao UI", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("No. Origenes");

        jLabel31.setFont(new java.awt.Font("Lao UI", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("No. Destinos");

        jTable2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "                 A", "                 B", "                 C", "                 D"
            }
        ));
        jTable2.setGridColor(new java.awt.Color(255, 255, 255));
        jTable2.setIntercellSpacing(new java.awt.Dimension(3, 3));
        jScrollPane5.setViewportView(jTable2);

        javax.swing.GroupLayout TransporteFLayout = new javax.swing.GroupLayout(TransporteF);
        TransporteF.setLayout(TransporteFLayout);
        TransporteFLayout.setHorizontalGroup(
            TransporteFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TransporteFLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addGap(321, 321, 321))
            .addGroup(TransporteFLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(TransporteFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator6)
                    .addGroup(TransporteFLayout.createSequentialGroup()
                        .addGroup(TransporteFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator7)
                            .addComponent(txtNro_Origen)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNro_Destino, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator8))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)))
                .addContainerGap())
        );
        TransporteFLayout.setVerticalGroup(
            TransporteFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransporteFLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel29)
                .addGap(17, 17, 17)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TransporteFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TransporteFLayout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNro_Origen, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNro_Destino, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(221, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SimplexLayout = new javax.swing.GroupLayout(Simplex);
        Simplex.setLayout(SimplexLayout);
        SimplexLayout.setHorizontalGroup(
            SimplexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SimplexLayout.createSequentialGroup()
                .addGroup(SimplexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SimplexLayout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(btnSMaximizarr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnSMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SimplexLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(simplex_max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(SimplexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SimplexLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Simplex_Min, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(SimplexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SimplexLayout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(TransporteF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        SimplexLayout.setVerticalGroup(
            SimplexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SimplexLayout.createSequentialGroup()
                .addGroup(SimplexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSMaximizarr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSMinimizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(simplex_max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(SimplexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SimplexLayout.createSequentialGroup()
                    .addContainerGap(99, Short.MAX_VALUE)
                    .addComponent(Simplex_Min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(SimplexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SimplexLayout.createSequentialGroup()
                    .addGap(82, 82, 82)
                    .addComponent(TransporteF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        btnSalir.setBackground(new java.awt.Color(29, 20, 43));
        btnSalir.setForeground(new java.awt.Color(29, 20, 43));
        btnSalir.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btnSalirMouseDragged(evt);
            }
        });
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalirMouseExited(evt);
            }
        });

        jLabel28.setBackground(new java.awt.Color(29, 20, 43));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Delete_35px.png"))); // NOI18N
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel28MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel28MouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnSalirLayout = new javax.swing.GroupLayout(btnSalir);
        btnSalir.setLayout(btnSalirLayout);
        btnSalirLayout.setHorizontalGroup(
            btnSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnSalirLayout.setVerticalGroup(
            btnSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Simplex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Simplex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnSimplexMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimplexMouseClicked
       sim=true;
       inven=trans=esper=false;
        //Color botones
        setColor(btnSimplex);
        resetColor(btnInventarios);
        resetColor(btnTransporte);
        resetColor(btnEspera);
        //Ocultar paneles
        this.btnSMaximizarr.setVisible(true);
        this.btnSMinimizar.setVisible(true);
        this.Simplex.setVisible(true);
        this.TransporteF.setVisible(false);
        
    }//GEN-LAST:event_btnSimplexMouseClicked

    //Auxiliar colores boton
    boolean sim=false,trans=false,inven=false,esper=false;
    

    private void btnInventariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInventariosMouseClicked
        //Color botones
        inven=true;
        sim=trans=esper=false;
        
        setColor(btnInventarios);
        resetColor(btnSimplex);
        resetColor(btnTransporte);
        resetColor(btnEspera);
        
        //Ocultar paneles
        ocultaSimplex();
        this.TransporteF.setVisible(false);
    }//GEN-LAST:event_btnInventariosMouseClicked

    private void btnTransporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransporteMouseClicked
        this.TransporteF.setVisible(true);
        trans=true;
        sim=inven=esper=false;
//Color botones
        setColor(btnTransporte);
        resetColor(btnInventarios);
        resetColor(btnSimplex);
        resetColor(btnEspera);
        
        //Ocultar paneles
        ocultaSimplex();
    }//GEN-LAST:event_btnTransporteMouseClicked

    
    boolean sim_max=false,sim_min=false;
    private void btnEsperaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEsperaMouseClicked
        esper=true;
        sim=trans=inven=false;
        setColor(btnEspera);
        resetColor(btnInventarios);
        resetColor(btnSimplex);
        resetColor(btnTransporte);
        
        this.ocultaSimplex();
        this.TransporteF.setVisible(false);
        
    }//GEN-LAST:event_btnEsperaMouseClicked
//Simplex Minimizar
    private void btnSMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSMinimizarMouseClicked

        sim_max=false;
        sim_min=true;
        //SIMPLEX
        setColor(btnSMinimizar);
        resetColor(btnSMaximizarr);
        //Oculta 
        this.simplex_max.setVisible(false);
        this.Simplex_Min.setVisible(true);
    }//GEN-LAST:event_btnSMinimizarMouseClicked
// SIMPLEX MAXIMIZAR
    private void btnSMaximizarrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSMaximizarrMouseClicked
        sim_max=true;
        sim_min=false;
        setColor(btnSMaximizarr);
        resetColor(btnSMinimizar);
        //Oculta
        this.simplex_max.setVisible(true);
        this.Simplex_Min.setVisible(false);
    }//GEN-LAST:event_btnSMaximizarrMouseClicked

    private void btnSimAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimAceptarMouseClicked
       this.Simplex.setVisible(true);
       this.panelTablaSim1.setVisible(true);
       //Aceptar simplex
       setColor(btnSimAceptar);
       try {
            restricciones = Integer.parseInt(txtRestriccionMax.getText());
            variables = Integer.parseInt(txtVariableMax.getText());

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.setRowCount(restricciones + 1);
            modelo.setColumnCount(variables + restricciones + 2);
            array = new Object[variables + restricciones + 2];
            EtiquetaX = new Object[variables + restricciones];
            for (int i = 1; i < array.length - 1; i++) {
                if (i < variables + 1) {
                    array[i] = "X" + i;
                    EtiquetaX[i - 1] = "X" + i;
                } else {
                    array[i] = "S" + (i - variables);
                    EtiquetaX[i - 1] = "S" + (i - variables);
                }
            }
            //---------------------
            EtiquetaY = new Object[restricciones + 1];
            for (int i = 0; i < restricciones; i++) {
                modelo.setValueAt("S" + (i + 1), i, 0);
                EtiquetaY[i] = "S" + (i + 1);
            }
            modelo.setValueAt("Z", restricciones, 0);
            EtiquetaY[restricciones] = "Z";
            //----------------------
            array[array.length - 1] = "soluc";
            modelo.setColumnIdentifiers(array);
            jTable1.setModel(modelo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
        }
        
    }//GEN-LAST:event_btnSimAceptarMouseClicked

    private void btnSolucionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSolucionMouseClicked
        // SOLUCION SIMPLEX MAX
        try {
            DefaultTableModel modeloSolucion = new DefaultTableModel();
            Matriz = new double[restricciones + 1][restricciones + variables + 1];
            for (int i = 0; i < (restricciones + 1); i++) {
                for (int j = 0; j < (restricciones + variables + 1); j++) {
                    Matriz[i][j] = Double.parseDouble(jTable1.getValueAt(i, j + 1).toString());
                }
            }
            while (ComprobarResultado() != true) {
                EtiquetaY[FilaPivote()] = EtiquetaX[ColumnaPivote()];
                NuevaTabla(FilaPivote(), ColumnaPivote());
                modeloSolucion.setColumnCount(restricciones + variables + 2);
                modeloSolucion.setRowCount(restricciones + 1);
                //--------------------------
                modeloSolucion.setColumnIdentifiers(array);
                //---------------------------
                for (int i = 0; i < (restricciones + 1); i++) {
                    modeloSolucion.setValueAt(EtiquetaY[i], i, 0);
                    for (int j = 0; j < (restricciones + variables + 1); j++) {
                        modeloSolucion.setValueAt(Matriz[i][j], i, j + 1);
                    }
                }
                jTableSolucion.setModel(modeloSolucion);
                iteracion++;
            }
            btnSolucion.setEnabled(false);
            btnSolucion1.setEnabled(true);
            Thread.sleep(3000);
            
            } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
        }
        
        
        
    }//GEN-LAST:event_btnSolucionMouseClicked

    private void btnSolucion1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSolucion1MouseClicked
        // ITERACION SIMPLEX MAX
        try {
            DefaultTableModel modeloSolucion = new DefaultTableModel();
            Matriz = new double[restricciones + 1][restricciones + variables + 1];
            for (int i = 0; i < (restricciones + 1); i++) {
                for (int j = 0; j < (restricciones + variables + 1); j++) {
                    Matriz[i][j] = Double.parseDouble(jTable1.getValueAt(i, j + 1).toString());
                }
            }
            int k = 0;
            iter++;
            if (iter <= iteracion) {
                //lbl_Iteraccion.setText(": " + iter);
                while (iter > k) {
                    EtiquetaY[FilaPivote()] = EtiquetaX[ColumnaPivote()];
                    NuevaTabla(FilaPivote(), ColumnaPivote());
                    modeloSolucion.setColumnCount(restricciones + variables + 2);
                    modeloSolucion.setRowCount(restricciones + 1);
                    //--------------------------
                    modeloSolucion.setColumnIdentifiers(array);
                    //---------------------------
                    for (int i = 0; i < (restricciones + 1); i++) {
                        modeloSolucion.setValueAt(EtiquetaY[i], i, 0);
                        for (int j = 0; j < (restricciones + variables + 1); j++) {
                            modeloSolucion.setValueAt(Matriz[i][j], i, j + 1);
                        }
                    }
                    jTableSolucion.setModel(modeloSolucion);
                    k++;
                }
            } else {
                iter = 0;
                iteracion = 0;
               // lbl_Iteraccion.setText("Final");
                btnSolucion.setEnabled(true);
                btnSolucion1.setEnabled(false);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
        }
    }//GEN-LAST:event_btnSolucion1MouseClicked

    //SIMPLEX MINIMIZAR
    private void txtRestriccionMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRestriccionMaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRestriccionMaxActionPerformed

    private void txtRestriccionMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRestriccionMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRestriccionMinActionPerformed

    private void btnSimAceptar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimAceptar1MouseClicked
        this.panelTablaSimMIN.setVisible(true);
        setColor(btnSimAceptar1);
        try {
            restriccionesMin = Integer.parseInt(txtRestriccionMin.getText());
            variablesMin = Integer.parseInt(txtVariableMin.getText());

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.setRowCount(restriccionesMin + 1);
            modelo.setColumnCount(variablesMin + restriccionesMin + 2);
            arrayMin = new Object[variablesMin + restriccionesMin + 2];
            EtiquetaXMin = new Object[variablesMin + restriccionesMin];
            for (int i = 1; i < arrayMin.length - 1; i++) {
                if (i < variablesMin + 1) {
                    arrayMin[i] = "X" + i;
                    EtiquetaXMin[i - 1] = "X" + i;
                } else {
                    arrayMin[i] = "S" + (i - variablesMin);
                    EtiquetaXMin[i - 1] = "S" + (i - variablesMin);
                }
            }
            //---------------------
            EtiquetaYMin = new Object[restriccionesMin + 1];
            for (int i = 0; i < restriccionesMin; i++) {
                modelo.setValueAt("S" + (i + 1), i, 0);
                EtiquetaYMin[i] = "S" + (i + 1);
            }
            modelo.setValueAt("Z", restriccionesMin, 0);
            EtiquetaYMin[restriccionesMin] = "Z";
            //----------------------
            arrayMin[arrayMin.length - 1] = "soluc";
            modelo.setColumnIdentifiers(arrayMin);
            jTable1Min.setModel(modelo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
        }
    }//GEN-LAST:event_btnSimAceptar1MouseClicked

    private void btnSolucionMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSolucionMinMouseClicked
        try {
            DefaultTableModel modeloSolucion = new DefaultTableModel();
            MatrizMin = new double[restriccionesMin + 1][restriccionesMin + variablesMin + 1];
            for (int i = 0; i < (restriccionesMin + 1); i++) {
                for (int j = 0; j < (restriccionesMin + variablesMin + 1); j++) {
                    MatrizMin[i][j] = Double.parseDouble(jTable1Min.getValueAt(i, j + 1).toString());
                }
            }
            while (ComprobarResultadoMin() != true) {
                EtiquetaYMin[FilaPivoteMin()] = EtiquetaXMin[ColumnaPivoteMin()];
                NuevaTablaMin(FilaPivoteMin(), ColumnaPivoteMin());
                modeloSolucion.setColumnCount(restriccionesMin + variablesMin + 2);
                modeloSolucion.setRowCount(restriccionesMin + 1);
                //--------------------------
                modeloSolucion.setColumnIdentifiers(arrayMin);
                //---------------------------
                for (int i = 0; i < (restriccionesMin + 1); i++) {
                    modeloSolucion.setValueAt(EtiquetaYMin[i], i, 0);
                    for (int j = 0; j < (restriccionesMin + variablesMin + 1); j++) {
                        modeloSolucion.setValueAt(MatrizMin[i][j], i, j + 1);
                    }
                }
                jTableSolucionMin.setModel(modeloSolucion);
                iteracionMin++;
            }
            btnSolucion.setEnabled(false);
            btnSolucion1.setEnabled(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
        }
    }//GEN-LAST:event_btnSolucionMinMouseClicked

    private void btnSolucion1MinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSolucion1MinMouseClicked
        try {
            DefaultTableModel modeloSolucion = new DefaultTableModel();
            MatrizMin = new double[restriccionesMin + 1][restriccionesMin + variablesMin + 1];
            for (int i = 0; i < (restriccionesMin + 1); i++) {
                for (int j = 0; j < (restriccionesMin + variablesMin + 1); j++) {
                    MatrizMin[i][j] = Double.parseDouble(jTable1Min.getValueAt(i, j + 1).toString());
                }
            }
            int k = 0;
            iterMin++;
            if (iterMin <= iteracionMin) {
               // lbl_Iteraccion.setText(": " + iterMin);
                while (iterMin > k) {
                    EtiquetaYMin[FilaPivoteMin()] = EtiquetaXMin[ColumnaPivoteMin()];
                    NuevaTablaMin(FilaPivoteMin(), ColumnaPivoteMin());
                    modeloSolucion.setColumnCount(restriccionesMin + variablesMin + 2);
                    modeloSolucion.setRowCount(restriccionesMin + 1);
                    //--------------------------
                    modeloSolucion.setColumnIdentifiers(arrayMin);
                    //---------------------------
                    for (int i = 0; i < (restriccionesMin + 1); i++) {
                        modeloSolucion.setValueAt(EtiquetaYMin[i], i, 0);
                        for (int j = 0; j < (restriccionesMin + variablesMin + 1); j++) {
                            modeloSolucion.setValueAt(MatrizMin[i][j], i, j + 1);
                        }
                    }
                    jTableSolucionMin.setModel(modeloSolucion);
                    k++;
                }
            } else {
                iterMin = 0;
                iteracionMin = 0;
                //lbl_Iteraccion.setText("Final");
                btnSolucion.setEnabled(true);
                btnSolucion1.setEnabled(false);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
        }
    }//GEN-LAST:event_btnSolucion1MinMouseClicked

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        System.exit(1);
    }//GEN-LAST:event_btnSalirMouseClicked

    private void btnSalirMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseDragged
        
    }//GEN-LAST:event_btnSalirMouseDragged

    private void jLabel28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseEntered
        setColor(btnSalir);
    }//GEN-LAST:event_jLabel28MouseEntered

    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        
    }//GEN-LAST:event_btnSalirMouseEntered

    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
       
    }//GEN-LAST:event_btnSalirMouseExited

    private void jLabel28MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseExited
         resetColor(btnSalir);
    }//GEN-LAST:event_jLabel28MouseExited

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        System.exit(1);
    }//GEN-LAST:event_jLabel28MouseClicked

    //ANIMACIONES :'v
    private void btnSimplexMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimplexMouseEntered
       setColor(btnSimplex);
       
    }//GEN-LAST:event_btnSimplexMouseEntered

    private void btnSimplexMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimplexMouseExited
        if(!sim) resetColor(btnSimplex);
        
        
    }//GEN-LAST:event_btnSimplexMouseExited

    private void btnTransporteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransporteMouseEntered
        setColor(btnTransporte);
    }//GEN-LAST:event_btnTransporteMouseEntered

    private void btnTransporteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransporteMouseExited
       if(!trans) resetColor(btnTransporte);
    }//GEN-LAST:event_btnTransporteMouseExited

    private void btnInventariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInventariosMouseEntered
         setColor(btnInventarios);
    }//GEN-LAST:event_btnInventariosMouseEntered

    private void btnInventariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInventariosMouseExited
        if(!inven) resetColor(btnInventarios);
    }//GEN-LAST:event_btnInventariosMouseExited

    private void btnEsperaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEsperaMouseEntered
        setColor(btnEspera);
    }//GEN-LAST:event_btnEsperaMouseEntered

    private void btnEsperaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEsperaMouseExited
        if(!esper) resetColor(btnEspera);
    }//GEN-LAST:event_btnEsperaMouseExited

    private void btnSMaximizarrMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSMaximizarrMouseEntered
        setColor(btnSMaximizarr);
    }//GEN-LAST:event_btnSMaximizarrMouseEntered

    private void btnSMaximizarrMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSMaximizarrMouseExited
        if(!sim_max) resetColor(btnSMaximizarr);
    }//GEN-LAST:event_btnSMaximizarrMouseExited

    private void btnSMinimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSMinimizarMouseEntered
        setColor(btnSMinimizar);
    }//GEN-LAST:event_btnSMinimizarMouseEntered

    private void btnSMinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSMinimizarMouseExited
        if(!sim_min) resetColor(btnSMinimizar);
    }//GEN-LAST:event_btnSMinimizarMouseExited

    
    void setColor(JPanel panel){
        panel.setBackground(new java.awt.Color(44, 31, 65));
    }
    void resetColor(JPanel panel){
        
        panel.setBackground(new java.awt.Color(29,20,43));
    }
    public Image getIconImage(){
        Image retValue=Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icons/Icono.png"));
        return retValue;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    public void refresh(){
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Simplex;
    private javax.swing.JPanel Simplex_Min;
    private javax.swing.JPanel TransporteF;
    private javax.swing.JPanel btnEspera;
    private javax.swing.JPanel btnInventarios;
    private javax.swing.JPanel btnSMaximizarr;
    private javax.swing.JPanel btnSMinimizar;
    private javax.swing.JPanel btnSalir;
    private javax.swing.JPanel btnSimAceptar;
    private javax.swing.JPanel btnSimAceptar1;
    private javax.swing.JPanel btnSimplex;
    private javax.swing.JPanel btnSolucion;
    private javax.swing.JPanel btnSolucion1;
    private javax.swing.JPanel btnSolucion1Min;
    private javax.swing.JPanel btnSolucionMin;
    private javax.swing.JPanel btnTransporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable1Min;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTableSolucion;
    private javax.swing.JTable jTableSolucionMin;
    private javax.swing.JPanel panelTablaSim1;
    private javax.swing.JPanel panelTablaSimMIN;
    private javax.swing.JPanel simplex_max;
    private javax.swing.JPanel simplex_max1;
    private javax.swing.JTextField txtNro_Destino;
    private javax.swing.JTextField txtNro_Origen;
    private javax.swing.JTextField txtRestriccionMax;
    private javax.swing.JTextField txtRestriccionMin;
    private javax.swing.JTextField txtVariableMax;
    private javax.swing.JTextField txtVariableMin;
    // End of variables declaration//GEN-END:variables
}
