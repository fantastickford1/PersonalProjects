package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private TreeView<File> treeView;
    @FXML private ImageView imageViewer;
    @FXML private MenuItem deleteContext;

    private Node folder;
    private Node txtFile;
    private Node pngFile;


    @FXML private void deleteFile(ActionEvent event){
        TreeItem<File> selectedItem = (TreeItem<File>) treeView.getSelectionModel().selectedItemProperty().getValue();
        try {
            selectedItem.getValue().delete();
        }catch (SecurityException e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        folder = new ImageView(new Image(getClass().getResourceAsStream("/img/folderIcon16.png")));
        txtFile = new ImageView(new Image(getClass().getResourceAsStream("/img/textIcon16.png")));
        pngFile = new ImageView(new Image(getClass().getResourceAsStream("/img/pngIcon16.png")));

        File currentDir = new File(".//fantastickford1//");
        if (currentDir.exists()){
            System.out.println("The directory exist");
        }else {
            currentDir.mkdir();
        }
        /*->Metodo recursivo*/findFiles(currentDir,null);
    }

    private void findFiles(File dir, TreeItem<File> parent){
        TreeItem<File> root = new TreeItem<>(dir,folder);
        root.setExpanded(true);
        try {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isDirectory()){
                    System.out.println("Directory: " + file.getCanonicalPath());
                    findFiles(file,root);
                }else{
                    System.out.println("-> File: " + file.getCanonicalPath());
                    root.getChildren().add(new TreeItem<>(file,txtFile));
                }
            }
            if (parent == null){
                System.out.println("treeView:root -> root");
                treeView.setRoot(root);
            }else {
                System.out.println("parent:children -> root");
                parent.getChildren().add(root);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
