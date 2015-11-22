package SaveFileBrowser;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeView;
import javafx.scene.layout.TilePane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Karlos on 11/22/2015.
 */
public class SaveFileBrowserController implements Initializable {

    @FXML
    private TreeView<String> treeView;
    @FXML private TilePane tilePane;




    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
