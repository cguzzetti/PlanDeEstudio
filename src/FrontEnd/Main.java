package FrontEnd;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        EstadoDeAplicacion estado = new EstadoDeAplicacion();
        VentanaInicio ventanaInicio = new VentanaInicio(primaryStage, estado);
        primaryStage.show();
    }
}

//private ApplicationData applicationData;

//private Stage primaryStage = new Stage();
//private FileChooser fileChooser = new FileChooser();


	/*private void loadComent() {
    	try {
    		File file = fileChooser.showOpenDialog(Main.this.primaryStage);
    		if(file != null) {
    			try {
    				loadData(file);
    			} catch (Exception ex) {
    				new Alert(Alert.AlertType.ERROR, "Error al cargar el archivo.").show();
    				return;
    			}
    		}
    		comentarios.set(applicationData.getComentarios());
    	} catch(Exception ex) {
    		new Alert(Alert.AlertType.ERROR, "No se pudo cargar los comentarios.").show();
    		}
    }

    private void loadData(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        applicationData = (ApplicationData) objectInputStream.readObject();
        objectInputStream.close();
    }

    private void saveComent() {
    	try {
    		File file = fileChooser.showSaveDialog(Main.this.primaryStage);
            if(file != null) {
                try {
                    saveData(file);
                } catch (Exception ex) {
                    new Alert(Alert.AlertType.ERROR, "Error al guardar los comentarios.").show();
                }
            }
		} catch (Exception ex) {new Alert(Alert.AlertType.ERROR, "No se pudo guardar los comentarios.").show();}
    }


    private void saveData(File file) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(applicationData);
        objectOutputStream.close();
    }
			}*/
        /*Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));

        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.show();*/

