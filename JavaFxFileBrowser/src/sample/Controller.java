package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private TreeView<File> treeView;
    @FXML private TilePane tilePane;
    @FXML private MenuItem deleteContext;

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

        File currentDir = new File(".//fantastickford1//");
        if (currentDir.exists()){
            System.out.println("The directory exist");
        }else {
            currentDir.mkdir();
        }
        findFiles(currentDir,null);

        treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                TreeItem<File> selectedTreeItem = (TreeItem<File>) newValue;
                File thisFile = selectedTreeItem.getValue();
                System.out.println(thisFile.getPath());
            }
        });
        ///*->Metodo recursivo*/findFiles(currentDir,null);

    }

    private void findFiles(File dir, TreeItem<File> parent){
        Node folder = new ImageView(new Image(getClass().getResourceAsStream("/img/folderIcon16.png")));
        TreeItem<File> root = new TreeItem<>(dir,folder);
        //root.setExpanded(true);
        try {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isDirectory()){
                    System.out.println("Directory: " + file.getCanonicalPath());
                    findFiles(file,root);
                }else{
                    Node txtFile = new ImageView(new Image(getClass().getResourceAsStream("/img/textIcon16.png")));
                    Node pngFile = new ImageView(new Image(getClass().getResourceAsStream("/img/pngIcon16.png")));
                    System.out.println("-> File: " + file.getAbsolutePath());
                    if (file.getCanonicalPath().matches(".*\\b.txt\\b")){
                        root.getChildren().add(new TreeItem<>(file,txtFile));
                    }
                    if (file.getCanonicalPath().matches(".*\\b.png\\b"))
                        root.getChildren().add(new TreeItem<>(file,pngFile));
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
