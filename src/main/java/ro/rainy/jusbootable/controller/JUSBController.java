package ro.rainy.jusbootable.controller;

import ro.rainy.jusbootable.model.JUSBModel;
import ro.rainy.jusbootable.view.JUSBView;

/**
 * @proiect: jUSBootable
 * @autor: daniel
 * @data: 14/12/2020__19:12
 */
public class JUSBController {
    private final JUSBView view;
    private final JUSBModel model;

    public JUSBController(JUSBView view, JUSBModel model) {
        this.view = view;
        this.model = model;
        setUp();
    }

    private void setUp() {
        model.whenExceptionThrown(view::showException);
        model.whenInfoSend(view::showInfo);

        model.whenVisibilityChange(() -> view.setVisible(model.isFrameVisible()));
        model.whenSelectionChange(view::setBootSelectionTxt);
        model.whenInteractionDialogPopUp(message -> {
            if (view.showConfirmation(message) == 0) {
                model.makeUSBootable();
            }
        });
        model.whenVolumeNameChange(view::setVolumeLabelTxt);
        model.whenStartEnableChange(view::setStartBtnEnables);

        view.whenUserClickStartButton(model::preStageMakeUSBootable);
        view.whenUserClickCloseButton(model::prepareExit);
        view.whenUserClickBootSelectionButton(view::setBootSelectionFileChooserVisible);
        view.whenFileChooserSelectionChange(model::updateSelection);

        view.setUSBComboBoxModel(model.getUsbComboModel());
        view.setPartitionSchemeComboBoxModel(model.getPartitionSchemeComboModel());
        view.setTargetSystemComboBoxModel(model.getTargetSystemComboModel());
        view.setFileSystemComboBoxModel(model.getFileSystemTypeComboModel());
        view.setClusterComboBoxModel(model.getClusterComboModel());
        view.setFileChooserModel(model.getFileChooserModel());
        view.setProgressBarModel(model.getProgressBarModel());
        view.setVolumeTextModel(model.getVolumeTextDocModel());


        view.setIconImage(model.getLogo());
    }
}