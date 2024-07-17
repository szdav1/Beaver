package com.beaver.softw.app.view.dialogs.settings;

import java.awt.GridLayout;

import javax.swing.*;

import com.beaver.softw.app.control.dialogs.settings.AppearanceSettingsDialogController;
import com.beaver.softw.app.view.dialogs.AbstractDialog;
import com.beaver.softw.support.appdata.AppData;
import com.beaver.softw.support.config.Language;

public final class AppearanceSettingsDialog extends AbstractDialog {
	private final JLabel informationLabel;
	private final JComboBox<String> appearanceComboBox;
	private final JButton applyButton;

	public AppearanceSettingsDialog() {
		super();

		AppearanceSettingsDialogController controller = new AppearanceSettingsDialogController();

		this.informationLabel = new JLabel(Language.get("Dialogs.AppearanceSettingsInformation"));
		this.informationLabel.setIcon(UIManager.getIcon("OptionPane.warningIcon"));
		this.appearanceComboBox = new JComboBox<>();

		this.applyButton = new JButton(Language.get("Dialogs.ApplyButton"));
		this.applyButton.addActionListener(controller);

		this.setTitle(Language.get("Dialogs.AppearanceSettingsTitle"));
		this.setLayout(new GridLayout(3, 1));
		this.addWindowListener(controller);
		this.addLookAndFeels();
		this.constructDialogStructure();
	}

	private void addLookAndFeels() {
		for (String lookAndFeel : AppData.AVAILABLE_LOOK_AND_FEELS) {
			this.appearanceComboBox.addItem(lookAndFeel);
		}

		this.appearanceComboBox.setSelectedItem(AppData.CURRENT_LOOK_AND_FEEL);
	}

	public AbstractDialog reset() {
		this.appearanceComboBox.setSelectedItem(AppData.CURRENT_LOOK_AND_FEEL);

		return this;
	}

	@Override
	protected void constructDialogStructure() {
		JPanel informationPanel = new JPanel();
		JPanel contentPanel = new JPanel();
		JPanel bottomPanel = new JPanel();

		informationPanel.add(this.informationLabel);
		contentPanel.add(this.appearanceComboBox);
		bottomPanel.add(this.applyButton);

		this.add(informationPanel);
		this.add(contentPanel);
		this.add(bottomPanel);
		this.pack();
	}
}