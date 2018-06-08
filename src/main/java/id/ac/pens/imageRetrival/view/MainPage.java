/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pens.imageRetrival.view;

import id.ac.pens.imageRetrival.model.FileTypeFilter;
import id.ac.pens.imageRetrival.model.ImageFeature;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

/**
 *
 * @author rhr
 */
public class MainPage extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    private File pictures;
    private int[] loadedPicLBP = new int[256];
    private ArrayList<ImageFeature> dataLBP = new ArrayList<ImageFeature>();
    
    static final String[] EXTENSIONS = new String[]{
        "jpg", "png", "bmp" 
    };
    
    static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

        @Override
        public boolean accept(final File dir, final String name) {
            for (final String ext : EXTENSIONS) {
                if (name.endsWith("." + ext)) {
                    return (true);
                }
            }
            return (false);
        }
    };
    
    public MainPage() {
        initComponents();
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        URL dirname = this.getClass().getResource("/dataset");
        File dir = new File(dirname.getPath());
        
        if (dir.isDirectory()) { // make sure it's a directory
            
            try {
                System.out.println(dir.getAbsolutePath()+"/data-list.txt");
                FileWriter fw = new FileWriter(dir.getAbsolutePath()+"/data-list.txt");
                for (final File f : dir.listFiles(IMAGE_FILTER)) {
                    BufferedImage img = null;
                    
                    File dataSet = new File(dir.getAbsolutePath()+"/"+f.getName()+".txt");
                    
                    if(dataSet.exists() && !dataSet.isDirectory()) { 
                        BufferedReader b = new BufferedReader(new FileReader(dataSet));

                        String readLine = "";

                        int[] fiturLBP = new int[256];
                        int i = 0;
                        while ((readLine = b.readLine()) != null) {
                            fiturLBP[i] = Integer.valueOf(readLine);
                            i++;
                        }
                        this.dataLBP.add(new ImageFeature(f.getName(), fiturLBP));
                        
                    } else {
                        img = ImageIO.read(f);
                        
                        int[] fiturLBP = this.extracting(img);
                        this.dataLBP.add(new ImageFeature(f.getName(), fiturLBP));
                        
                        FileWriter dataSetWriter = new FileWriter(dir.getAbsolutePath()+"/"+f.getName()+".txt");
                        
                        for (int fitur : fiturLBP) {
                            dataSetWriter.write(fitur+"\n");
                        }
                        
                        dataSetWriter.close();
                        
                    }
                    
                    System.out.println("image: " + f.getName());

                    fw.write(f.getName()+"\n");
                    
                }
                fw.close();
            } catch (final IOException e) {
                e.printStackTrace();
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
        judulLabel = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        iconLabel = new javax.swing.JLabel();
        jLabelRes3 = new javax.swing.JLabel();
        jLabelRes1 = new javax.swing.JLabel();
        jLabelRes2 = new javax.swing.JLabel();
        jLabelRes4 = new javax.swing.JLabel();
        jLabelRes5 = new javax.swing.JLabel();
        jLabelRes6 = new javax.swing.JLabel();
        jLabelRes7 = new javax.swing.JLabel();
        jLabelRes8 = new javax.swing.JLabel();
        jLabelRes9 = new javax.swing.JLabel();
        jLabelRes10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        judulLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        judulLabel.setText("Java Image Retrieval");

        searchTextField.setText("Find Your Images");
        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/camera.png"))); // NOI18N
        iconLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconLabelMouseClicked(evt);
            }
        });

        jLabelRes3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelRes1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelRes2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelRes4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelRes5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelRes6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelRes7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelRes8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelRes9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelRes10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(judulLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelRes9, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelRes6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelRes1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelRes7, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelRes2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelRes3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelRes8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(iconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchButton))
                            .addComponent(jLabelRes4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelRes5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRes10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelRes4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(judulLabel)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(searchButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(searchTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                        .addComponent(iconLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelRes3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRes2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRes1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelRes5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelRes9, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRes8, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRes7, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRes6, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRes10, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        boolean found = false;
        for(ImageFeature image : dataLBP) {
            if(image.getName().equals(pictures.getName())) {
                found = true;
                loadedPicLBP = image.getLBP();
            }
        }
        
        if(!found) {
            try {
                loadedPicLBP = this.extracting(ImageIO.read(pictures));
            } catch (IOException ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        int difference;
        int[] index = new int[152];
        int[] value = new int[152];
        for (int i = 0; i < 152; i++)
        {
            difference = 0;
            for (int j = 0; j < 256; j++)
            {
                difference += Math.abs(loadedPicLBP[j] - dataLBP.get(i).getLBP()[j]);
            }
            index[i] = i;
            value[i] = difference;
        }
        for (int i = 0; i < 152; i++)
        {
            for (int j = 0; j < 151; j++)
            {
                if (value[j] > value[j + 1])
                {
                    int tmp = value[j];
                    value[j] = value[j + 1];
                    value[j + 1] = tmp;

                    tmp = index[j];
                    index[j] = index[j + 1];
                    index[j + 1] = tmp;
                }
            }
        }
        
        jLabelRes1.setIcon(new ImageIcon(getClass().getResource("/dataset/"+dataLBP.get(index[0]).getName())));
        jLabelRes2.setIcon(new ImageIcon(getClass().getResource("/dataset/"+dataLBP.get(index[1]).getName())));
        jLabelRes3.setIcon(new ImageIcon(getClass().getResource("/dataset/"+dataLBP.get(index[2]).getName())));
        jLabelRes4.setIcon(new ImageIcon(getClass().getResource("/dataset/"+dataLBP.get(index[3]).getName())));
        jLabelRes5.setIcon(new ImageIcon(getClass().getResource("/dataset/"+dataLBP.get(index[4]).getName())));
        jLabelRes6.setIcon(new ImageIcon(getClass().getResource("/dataset/"+dataLBP.get(index[5]).getName())));
        jLabelRes7.setIcon(new ImageIcon(getClass().getResource("/dataset/"+dataLBP.get(index[6]).getName())));
        jLabelRes8.setIcon(new ImageIcon(getClass().getResource("/dataset/"+dataLBP.get(index[7]).getName())));
        jLabelRes9.setIcon(new ImageIcon(getClass().getResource("/dataset/"+dataLBP.get(index[8]).getName())));
        jLabelRes10.setIcon(new ImageIcon(getClass().getResource("/dataset/"+dataLBP.get(index[9]).getName())));
        
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void iconLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconLabelMouseClicked
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Please Select Multiband Images");
        chooser.setFileFilter(new FileTypeFilter(".jpg", "JPG"));
        chooser.setFileFilter(new FileTypeFilter(".jpeg", "JPEG"));
        chooser.setFileFilter(new FileTypeFilter(".gif", "GIF"));
        chooser.setFileFilter(new FileTypeFilter(".png", "PNG"));
        chooser.showOpenDialog(null);
        pictures = chooser.getSelectedFile();
        String filename = pictures.getAbsolutePath();
        searchTextField.setText(filename);  
        JLabel JLabelPicture = new JLabel(new ImageIcon(pictures.getAbsolutePath()));
        jPanel2.add(JLabelPicture);
        
        revalidate();
        repaint();
    }//GEN-LAST:event_iconLabelMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconLabel;
    private javax.swing.JLabel jLabelRes1;
    private javax.swing.JLabel jLabelRes10;
    private javax.swing.JLabel jLabelRes2;
    private javax.swing.JLabel jLabelRes3;
    private javax.swing.JLabel jLabelRes4;
    private javax.swing.JLabel jLabelRes5;
    private javax.swing.JLabel jLabelRes6;
    private javax.swing.JLabel jLabelRes7;
    private javax.swing.JLabel jLabelRes8;
    private javax.swing.JLabel jLabelRes9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel judulLabel;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    // End of variables declaration//GEN-END:variables

    private int[] extracting(BufferedImage img){
        BufferedImage grayScale = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
        int[] nilaiLBP = new int[256];
        for (int i = 0; i < 256; i++) {
            nilaiLBP[i] = 0;
        }
        for(int i=0; i<img.getWidth(); i++){
            for(int j=0; j<img.getHeight(); j++){
                Color c = new Color(img.getRGB(i, j));
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();
                int a = c.getAlpha();
                        
                int gr = (r + g + b)/3;
                        
                Color gColor = new Color(gr, gr, gr, a);
                grayScale.setRGB(i, j, gColor.getRGB());
            }
        }
        for (int y = 1; y < grayScale.getHeight() - 1; y++)
            {
                for (int x = 1; x < grayScale.getWidth() - 1; x++)
                {
                    int value = LBP(x, y, grayScale);
                    nilaiLBP[value] += 1;
                }
            }

        return nilaiLBP;
        
    }

    private int LBP(int x, int y, BufferedImage grayScale) {
        //To change body of generated methods, choose Tools | Templates.
        int[] data = new int[8];
        int mindata = 256;
        int tmpdata = 0;
        Color col = new Color(grayScale.getRGB(x, y));
        Color col1 = new Color(grayScale.getRGB(x-1, y-1));
        Color col2 = new Color(grayScale.getRGB(x, y));
        Color col3 = new Color(grayScale.getRGB(x, y-1));
        Color col4 = new Color(grayScale.getRGB(x+1, y));
        Color col5 = new Color(grayScale.getRGB(x+1, y+1));
        Color col6 = new Color(grayScale.getRGB(x, y+1));
        Color col7 = new Color(grayScale.getRGB(x-1, y+1));
        Color col8 = new Color(grayScale.getRGB(x-1, y));
        
        if(col.getRed() > col1.getRed())
            data[0] = 0;
        else
            data[0] = 1;
        if(col.getRed() > col2.getRed())
            data[1] = 0;
        else
            data[1] = 1;
        if(col.getRed() > col3.getRed())
            data[2] = 0;
        else
            data[2] = 1;
        if(col.getRed() > col4.getRed())
            data[3] = 0;
        else
            data[3] = 1;
        if(col.getRed() > col5.getRed())
            data[4] = 0;
        else
            data[4] = 1;
        if(col.getRed() > col6.getRed())
            data[5] = 0;
        else
            data[5] = 1;
        if(col.getRed() > col7.getRed())
            data[6] = 0;
        else
            data[6] = 1;
        if(col.getRed() > col8.getRed())
            data[7] = 0;
        else
            data[7] = 1;
        
        for(int i=0; i<8; i++){
            tmpdata = Convert(data);
            if(tmpdata < mindata)
                mindata = tmpdata;
            data = Swap(data);
        }
        return mindata;
    }

    private int Convert(int[] data) {
        //To change body of generated methods, choose Tools | Templates.
        int retval = 0;
        int[] tmp = new int[8];
        int cnt = 7;
        for(int i=0; i<8; i++){
            tmp[i] = data[cnt];
            cnt--;
        }
        
        for(int i=0; i<8; i++){
            if(tmp[i] == 1){
             retval += (int)Math.pow(2, i);
            }
        }
        return retval;
    }

    private int[] Swap(int[] data) {
        //To change body of generated methods, choose Tools | Templates.
        int tmp = data[0];
        data[0] = data[1];
        data[1] = data[2];
        data[2] = data[3];
        data[3] = data[4];
        data[4] = data[5];
        data[5] = data[6];
        data[6] = data[7];
        data[7] = tmp;
        
        return data;
    }
    
    
    
}
