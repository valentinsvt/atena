/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atena;

import SecuGen.FDxSDKPro.jni.JSGFPLib;
import SecuGen.FDxSDKPro.jni.SGDeviceInfoParam;
import SecuGen.FDxSDKPro.jni.SGFDxErrorCode;
import SecuGen.FDxSDKPro.jni.SGFingerInfo;
import SecuGen.FDxSDKPro.jni.SGFingerPosition;
import SecuGen.FDxSDKPro.jni.SGImpressionType;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author svt
 */
public class RegistroBio extends javax.swing.JPanel {

    private JSGFPLib fplib;
    private SGDeviceInfoParam deviceInfo;
    static String mensaje = "";
    static long ret;
    private boolean r1Captured;
    private byte[] regMin1 = new byte[400];
    private boolean guardar;
    static Persona persona;
    SGFingerInfo fingerInfo;
    Huella huella;
    int[] quality;
    Inicio padre;

    /**
     * Creates new form RegistroBio
     */
    public RegistroBio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lblImg = new javax.swing.JLabel();
        panelBtnCapturar = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();

        setBackground(java.awt.Color.darkGray);
        setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Teléfono");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Apellido");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cédula");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email");

        txtCedula.setBackground(new java.awt.Color(102, 102, 102));
        txtCedula.setForeground(new java.awt.Color(255, 255, 255));
        txtCedula.setBorder(BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 204), 1, true), 
            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    txtCedula.setCaretColor(new java.awt.Color(255, 255, 255));
    txtCedula.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    txtCedula.setMargin(new java.awt.Insets(2, 5, 2, 5));
    txtCedula.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtCedulaActionPerformed(evt);
        }
    });
    txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            txtCedulaKeyPressed(evt);
        }
    });

    txtNombre.setBackground(new java.awt.Color(102, 102, 102));
    txtNombre.setForeground(new java.awt.Color(255, 255, 255));
    txtNombre.setBorder(BorderFactory.createCompoundBorder(
        new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 204), 1, true), 
        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
txtNombre.setCaretColor(new java.awt.Color(255, 255, 255));
txtNombre.setMargin(new java.awt.Insets(2, 5, 2, 5));
txtNombre.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtNombreActionPerformed(evt);
    }
    });

    txtApellido.setBackground(new java.awt.Color(102, 102, 102));
    txtApellido.setForeground(new java.awt.Color(255, 255, 255));
    txtApellido.setBorder(BorderFactory.createCompoundBorder(
        new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 204), 1, true), 
        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
txtApellido.setCaretColor(new java.awt.Color(255, 255, 255));
txtApellido.setMargin(new java.awt.Insets(2, 5, 2, 5));

txtTelefono.setBackground(new java.awt.Color(102, 102, 102));
txtTelefono.setForeground(new java.awt.Color(255, 255, 255));
txtTelefono.setBorder(BorderFactory.createCompoundBorder(
    new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 204), 1, true), 
    BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    txtTelefono.setCaretColor(new java.awt.Color(255, 255, 255));
    txtTelefono.setMargin(new java.awt.Insets(2, 5, 2, 5));

    txtEmail.setBackground(new java.awt.Color(102, 102, 102));
    txtEmail.setForeground(new java.awt.Color(255, 255, 255));
    txtEmail.setBorder(BorderFactory.createCompoundBorder(
        new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 204), 1, true), 
        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
txtEmail.setCaretColor(new java.awt.Color(255, 255, 255));
txtEmail.setMargin(new java.awt.Insets(2, 5, 2, 5));

jLabel6.setForeground(new java.awt.Color(255, 255, 255));
jLabel6.setText("Datos biométricos, coloque su dedo indice izquierdo.");

lblImg.setBackground(new java.awt.Color(255, 255, 255));
lblImg.setOpaque(true);
lblImg.setPreferredSize(new java.awt.Dimension(130, 150));

panelBtnCapturar.setBackground(new java.awt.Color(0, 153, 204));
panelBtnCapturar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 153, 255), java.awt.Color.white, null, null));
panelBtnCapturar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
panelBtnCapturar.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        panelBtnCapturarMouseClicked(evt);
    }
    });

    jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(255, 255, 255));
    jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel8.setText("Capturar");

    javax.swing.GroupLayout panelBtnCapturarLayout = new javax.swing.GroupLayout(panelBtnCapturar);
    panelBtnCapturar.setLayout(panelBtnCapturarLayout);
    panelBtnCapturarLayout.setHorizontalGroup(
        panelBtnCapturarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelBtnCapturarLayout.createSequentialGroup()
            .addGap(41, 41, 41)
            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(44, Short.MAX_VALUE))
    );
    panelBtnCapturarLayout.setVerticalGroup(
        panelBtnCapturarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
    );

    btnGuardar.setBackground(new java.awt.Color(0, 153, 204));
    btnGuardar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 153, 255), new java.awt.Color(255, 255, 255), null, null));
    btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            btnGuardarMouseClicked(evt);
        }
    });

    jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(255, 255, 255));
    jLabel9.setText("Guardar");

    javax.swing.GroupLayout btnGuardarLayout = new javax.swing.GroupLayout(btnGuardar);
    btnGuardar.setLayout(btnGuardarLayout);
    btnGuardarLayout.setHorizontalGroup(
        btnGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(btnGuardarLayout.createSequentialGroup()
            .addGap(57, 57, 57)
            .addComponent(jLabel9)
            .addContainerGap(61, Short.MAX_VALUE))
    );
    btnGuardarLayout.setVerticalGroup(
        btnGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnGuardarLayout.createSequentialGroup()
            .addContainerGap(23, Short.MAX_VALUE)
            .addComponent(jLabel9)
            .addGap(20, 20, 20))
    );

    lblMensaje.setForeground(new java.awt.Color(255, 255, 255));
    lblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    lblMensaje.setVerticalAlignment(javax.swing.SwingConstants.TOP);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(52, 52, 52)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombre)
                        .addComponent(txtApellido)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(120, 120, 120)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(panelBtnCapturar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblImg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addContainerGap(312, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(23, 23, 23)
            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(lblImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(18, 18, 18)
            .addComponent(panelBtnCapturar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(23, 23, 23))
    );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtCedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyPressed
        // TODO add your handling code here:
        int cant = txtCedula.getText().length();
        if (cant == 10) {
            txtCedula.setText(txtCedula.getText().substring(0, 9));
        }
    }//GEN-LAST:event_txtCedulaKeyPressed

    private void panelBtnCapturarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBtnCapturarMouseClicked

        quality = new int[1];
        BufferedImage imgRegistration1;
        System.out.println("capture 1? " + this.deviceInfo.imageWidth);
        imgRegistration1 = new BufferedImage(this.deviceInfo.imageWidth, this.deviceInfo.imageHeight, BufferedImage.TYPE_BYTE_GRAY);

        byte[] imageBuffer1 = ((DataBufferByte) imgRegistration1.getRaster().getDataBuffer()).getData();
        long iError = SGFDxErrorCode.SGFDX_ERROR_NONE;

        iError = fplib.GetImageEx(imageBuffer1, 3 * 1000, 0, 50);
        fplib.GetImageQuality(deviceInfo.imageWidth, deviceInfo.imageHeight, imageBuffer1, quality);
        fingerInfo = new SGFingerInfo();
        fingerInfo.FingerNumber = SGFingerPosition.SG_FINGPOS_LI;
        fingerInfo.ImageQuality = quality[0];
        fingerInfo.ImpressionType = SGImpressionType.SG_IMPTYPE_LP;
        fingerInfo.ViewNumber = 1;
        if (iError == SGFDxErrorCode.SGFDX_ERROR_NONE) {
            this.lblImg.setIcon(new ImageIcon(imgRegistration1.getScaledInstance(150, 140, Image.SCALE_DEFAULT)));
            if (quality[0] < 70) {
                mensaje = "<html>La imagen capturada no<br> tiene la calidad requerida<br>  por el sistema.<br>Por favor intente<br> nuevamente</html>";
            } else {

                mensaje = "GetImageEx() Success [" + ret + "]";
                //regMin byte[400]
                iError = fplib.CreateTemplate(fingerInfo, imageBuffer1, regMin1);
                if (iError == SGFDxErrorCode.SGFDX_ERROR_NONE) {
                    mensaje = "<html>Imagen capturada<br>exitosamente.</html>";
                    r1Captured = true;
                    //Huella huella = new Huella(fingerInfo.FingerNumber, quality[0], fingerInfo.ImpressionType, fingerInfo.ViewNumber, regMin1);
                    //huella.insert();
                    this.enableControls();
                } else {
                    mensaje = "CreateTemplate() Error : " + iError;
                    r1Captured = false;
                }
            }
        } else {
            mensaje = "<html>Tiempo de espera superado.<br>Por favor espere 5 segundos <br>y vuelva a intentarlo.</html>" + iError;
            r1Captured = false;
        }

        this.lblMensaje.setText(mensaje);
    }//GEN-LAST:event_panelBtnCapturarMouseClicked

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        // TODO add your handling code here:
        if (this.guardar) {
            boolean errores = false;
            persona = new Persona();
            persona.setNombre(txtNombre.getText());
            persona.setApellido(txtApellido.getText());
            persona.setMail(txtEmail.getText());
            persona.setTelefono(txtTelefono.getText());
            persona.setCedula(txtCedula.getText());
            errores = persona.save();
            if (!errores) {
                huella = new Huella(fingerInfo.FingerNumber, quality[0], fingerInfo.ImpressionType, fingerInfo.ViewNumber, regMin1, persona);
                errores = huella.insert();
                if (!errores) {
                    JOptionPane.showMessageDialog(this, "Datos guardados exitosamente");
                    this.padre.displayRegistro();
                } else {
                    JOptionPane.showMessageDialog(this, "Error: por favor revise los datos ingresados");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error: por favor revise los datos ingresados");
            }

        }


    }//GEN-LAST:event_btnGuardarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblImg;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JPanel panelBtnCapturar;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
void setFplib(JSGFPLib fplib) {
        this.fplib = fplib;
    }

    void setDeviveInfo(SGDeviceInfoParam deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    private void enableControls() {
        this.guardar = true;
    }

    public void setPadre(Inicio padre) {
        this.padre = padre;
    }
}
