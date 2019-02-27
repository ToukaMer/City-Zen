package gui;

import data.Stats;
import gui_data.BlockSize;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class DataDisplayer extends VBox {
	
	private BlockSize blockSize;
	private Label titleLabel;
	private Label moneyLabel;
	private Label nbResidentialLabel;
	private Label nbCommercialLabel;
	private Label nbAdministrativeLabel;
	private Label nbStationLabel;
	
	public DataDisplayer(double width, double height) {
		super();
		setBlockSize(new BlockSize(width, height));
		setPrefSize(getBlockSize().getWidth(), getBlockSize().getHeight());
		
		initializeLabels();
		
		getChildren().add(getTitleLabel());
		getChildren().add(getMoneyLabel());
		getChildren().add(getNbResidentialLabel());
		getChildren().add(getNbCommercialLabel());
		getChildren().add(getNbAdministrativeLabel());
	}
	
	public void initializeLabels() {
		initializeTitleLabel();
		initializeMoneyLabel();
		initializeNbResidentialLabel();
		initializeNbCommercialLabel();
		initializeNbAdministrativeLabel();
	}
	
	public void initializeTitleLabel() {
		setTitleLabel(new Label());
		getTitleLabel().setText("Data");
		getTitleLabel().getStyleClass().remove("label");
		getTitleLabel().getStyleClass().add("toolBoxLabel");
	}
	
	public void initializeMoneyLabel() {
		setMoneyLabel(new Label());
		getMoneyLabel().setText("Money :"+Stats.money);
		getMoneyLabel().getStyleClass().remove("label");
		getMoneyLabel().getStyleClass().add("dataLabel");
	}
	
	public void initializeNbResidentialLabel() {
		setNbResidentialLabel(new Label());
		getNbResidentialLabel().setText("Nb residential :"+Stats.nbResidence);
		getNbResidentialLabel().getStyleClass().remove("label");
		getNbResidentialLabel().getStyleClass().add("dataLabel");
	}
	
	public void initializeNbCommercialLabel() {
		setNbCommercialLabel(new Label());
		getNbCommercialLabel().setText("Nb commercial :"+Stats.nbCommercial);
		getNbCommercialLabel().getStyleClass().remove("label");
		getNbCommercialLabel().getStyleClass().add("dataLabel");
	}
	
	public void initializeNbAdministrativeLabel() {
		setNbAdministrativeLabel(new Label());
		getNbAdministrativeLabel().setText("Nb Administrative :"+Stats.nbAdministrative);
		getNbAdministrativeLabel().getStyleClass().remove("label");
		getNbAdministrativeLabel().getStyleClass().add("dataLabel");
	}
	
	public BlockSize getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(BlockSize blockSize) {
		this.blockSize = blockSize;
	}
	
	public Label getTitleLabel() {
		return titleLabel;
	}

	public void setTitleLabel(Label titleLabel) {
		this.titleLabel = titleLabel;
	}

	public Label getMoneyLabel() {
		return moneyLabel;
	}

	public void setMoneyLabel(Label moneyLabel) {
		this.moneyLabel = moneyLabel;
	}

	public Label getNbResidentialLabel() {
		return nbResidentialLabel;
	}

	public void setNbResidentialLabel(Label nbResidentialLabel) {
		this.nbResidentialLabel = nbResidentialLabel;
	}

	public Label getNbCommercialLabel() {
		return nbCommercialLabel;
	}

	public void setNbCommercialLabel(Label nbCommercialLabel) {
		this.nbCommercialLabel = nbCommercialLabel;
	}

	public Label getNbAdministrativeLabel() {
		return nbAdministrativeLabel;
	}

	public void setNbAdministrativeLabel(Label nbAdministrativeLabel) {
		this.nbAdministrativeLabel = nbAdministrativeLabel;
	}

	public Label getNbStationLabel() {
		return nbStationLabel;
	}

	public void setNbStationLabel(Label nbStationLabel) {
		this.nbStationLabel = nbStationLabel;
	}

	
}
