package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import modelo.CuadradoMagico;

public class indexController 
{
	
	 CuadradoMagico miCuadradito;
	 private GridPane grilla;
	 private Label[][] labelcitos;
	 @FXML
	 private BorderPane bpPanelcito;

	 @FXML
	 private TextField txtxTamanio;

	 @FXML
	 private ChoiceBox<String> cbUbicacion;

	 @FXML
	 private ChoiceBox<String> cbDireccion;
	 
	public indexController()
	{
		
	}
	@FXML
	public void initialize()
	{
		miCuadradito = new CuadradoMagico();
		grilla = new GridPane();
    	
    	cbUbicacion.getItems().addAll("Up", "Left", "Right", "Down");
    	cbUbicacion.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
    			{
    				@Override
    				public void changed(ObservableValue<? extends String> ob, String oldValue, String newValue)
    				{
    					cbDireccion.getItems().clear();
    					if(newValue.equals("Up"))
    					{
    						cbDireccion.getItems().addAll("NO", "NE");
    					}
    					if(newValue.equals("Left"))
    					{
    						cbDireccion.getItems().addAll("NO", "SO");
    					}
    					if(newValue.equals("Right"))
    					{
    						cbDireccion.getItems().addAll("NE", "SE");
    					}
    					if(newValue.equals("Down"))
    					{
    						cbDireccion.getItems().addAll("SO", "SE");
    					}
    				}
    			});

	}
	@FXML
    public void btnLlenarCuadrado(ActionEvent event) 
	{
		grilla.getChildren().clear();
		int x = 0;
		int y = 0;
		int sentido = 0;
		if(cbUbicacion.getValue().equals("Up")) 
		{
			x = 0;
			y = labelcitos.length/2;
		}
		else if(cbUbicacion.getValue().equals("Left"))
		{
			x = labelcitos.length/2;
			y = 0;
		}
		else if(cbUbicacion.getValue().equals("Right"))
		{
			x = labelcitos.length/2;
			y = labelcitos.length - 1;
		}
		else if(cbUbicacion.getValue().equals("Down"))
		{
			x = labelcitos.length-1;
			y = labelcitos.length/2;
		}
		else
		{
			System.out.println("dfd");
		}
		
		if(cbDireccion.getValue().equals("NO"))
		{
			sentido = 1;
			
		}
		else if(cbDireccion.getValue().equals("NE"))
		{
			sentido = 2;
		}
		else if(cbDireccion.getValue().equals("SO"))
		{
			sentido = 3;
		}
		else if(cbDireccion.getValue().equals("SE"))
		{
			sentido = 4;
		}
		else
		{
			System.out.println("dfdf");
		}
		miCuadradito.completarCuadrado(x, y, sentido);
		for (int i = 0; i < labelcitos.length; i++) 
		{
			for (int j = 0; j < labelcitos.length; j++) 
			{
				labelcitos[i][j] = new Label(""+ miCuadradito.getCuadrado()[i][j]);
			}
		}
		mostrarMatriz();
	}
	@FXML
	public void accionTamanio(ActionEvent event) 
	{
		bpPanelcito.setCenter(grilla);
		grilla.getChildren().clear();
		miCuadradito.setOrden(Integer.parseInt(txtxTamanio.getText()));
		labelcitos = new Label[miCuadradito.getOrden()][miCuadradito.getOrden()];
		for (int i = 0; i < labelcitos.length; i++) 
		{
			for (int j = 0; j < labelcitos.length; j++) 
			{
				if(i == 0 && j == labelcitos.length/2)
				{
					labelcitos[i][j] = new Label("U");
				}
				else if(i == labelcitos.length/2 && j == 0)
				{
					labelcitos[i][j] = new Label("L");
				}
				else if(i == labelcitos.length/2 && j == labelcitos.length - 1)
				{
					labelcitos[i][j] = new Label("R");
				}
				else if(i == labelcitos.length-1 && j == labelcitos.length/2)
				{
					labelcitos[i][j] = new Label("D");
				}
				else
				{
					labelcitos[i][j] = new Label("0");
				}
			}	
		}
		mostrarMatriz();
	}
	public void mostrarMatriz()
	{
		for (int i = 0; i < labelcitos.length; i++) 
		{
			for (int j = 0; j < labelcitos.length; j++) 
			{
				grilla.setVgap(17);
				grilla.setHgap(17);
				grilla.setAlignment(Pos.CENTER);
				grilla.add(labelcitos[i][j], j, i);
			}
		}
		
	}
	
   
}