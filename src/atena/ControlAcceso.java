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
import static atena.RegistroBio.mensaje;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/*
Prueba para la tonteria de git desde netbeans..........
otro test
*/
/**
 *
 * @author svt
 */
public class ControlAcceso extends javax.swing.JPanel {

    private JSGFPLib fplib;
    private SGDeviceInfoParam deviceInfo;
    static String mensaje = "";
    static long ret;
    private byte[] regMin1 = new byte[400];
    static Persona persona;
    SGFingerInfo fingerInfo;
    Huella huella;
    int[] quality;
    Inicio padre;
    private boolean disable = false;
    Timer timer;
    public ControlAcceso() {
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

        jLabel6 = new javax.swing.JLabel();
        lblImg = new javax.swing.JLabel();
        panelBtnCapturar = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();

        setBackground(java.awt.Color.darkGray);
        setPreferredSize(new java.awt.Dimension(1018, 655));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("<html>Control del acceso. <br>Por favor, coloque su dedo indice <br> izquierdo sobre el lector y presione verificar.</html>");

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
        jLabel8.setText("Verificar");

        javax.swing.GroupLayout panelBtnCapturarLayout = new javax.swing.GroupLayout(panelBtnCapturar);
        panelBtnCapturar.setLayout(panelBtnCapturarLayout);
        panelBtnCapturarLayout.setHorizontalGroup(
            panelBtnCapturarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtnCapturarLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBtnCapturarLayout.setVerticalGroup(
            panelBtnCapturarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        lblMensaje.setForeground(new java.awt.Color(255, 255, 255));
        lblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMensaje.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(panelBtnCapturar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblImg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(243, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(panelBtnCapturar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(310, 310, 310))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void panelBtnCapturarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBtnCapturarMouseClicked
         timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disable = false;
                //timer.stop();
            }
        });
       timer.setRepeats(false);
        if (!disable) {
            timer.start();
            disable=true;
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
                    } else {
                        mensaje = "CreateTemplate() Error : " + iError;
                    }
                }
            } else {
                mensaje = "<html>Tiempo de espera superado.<br>Por favor espere 5 segundos <br>y vuelva a intentarlo.</html>" + iError;
            }

            mensaje = "";
            ///////////////////////////verificacion///////////////////////////////////////

            long secuLevel = (long) (5);
            boolean[] matched = new boolean[1];
            matched[0] = false;

            Huella[] h = new Huella[4];
            for (int i = 13; i < 17; i++) {
                h[i - 13] = new Huella(i);
                System.out.println("VERIFICANDO!    h " + i + "  --> " + h[i - 13].getId());
                iError = fplib.MatchTemplate(h[i - 13].getData(), regMin1, secuLevel, matched);
                if (iError == SGFDxErrorCode.SGFDX_ERROR_NONE) {
                    if (matched[0]) {
                        mensaje = "Bienvenido " + h[i - 13].getNombre();
                        System.out.println("Matched!!!!");
                    } else {
                        System.out.println("no match");
                    }
                } else {
                    mensaje = "Verification Attempt 1 Fail - MatchTemplate() Error : " + iError;
                }

            }

            this.lblMensaje.setText(mensaje);
        }

    }//GEN-LAST:event_panelBtnCapturarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblImg;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JPanel panelBtnCapturar;
    // End of variables declaration//GEN-END:variables

    void setFplib(JSGFPLib fplib) {
        this.fplib = fplib;
    }

    void setDeviveInfo(SGDeviceInfoParam deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public void setPadre(Inicio padre) {
        this.padre = padre;
    }
}
