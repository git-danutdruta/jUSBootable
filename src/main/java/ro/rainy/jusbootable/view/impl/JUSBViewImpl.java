package ro.rainy.jusbootable.view.impl;

import net.miginfocom.swing.MigLayout;
import ro.rainy.jusbootable.handler.ButtonClickHandler;
import ro.rainy.jusbootable.handler.SelectionChangeHandler;
import ro.rainy.jusbootable.model.BComboModel;
import ro.rainy.jusbootable.model.BFileChooserModel;
import ro.rainy.jusbootable.model.BProgressBarBoundedRangeModel;
import ro.rainy.jusbootable.model.domain.*;
import ro.rainy.jusbootable.view.JUSBView;
import ro.rainy.jusbootable.view.component.BFileChooser;

import javax.swing.*;
import java.awt.*;

/**
 * @proiect: jUSBootable
 * @autor: daniel
 * @data: 14/12/2020__19:08
 */
public class JUSBViewImpl extends JFrame implements JUSBView {
    private JPanel contentPanel;

    private JPanel devicePanel;
    private JLabel flashDriveLbl;
    private JLabel bootSelectionLbl;
    private JLabel partitionSchemeLbl;
    private JLabel targetSystemLbl;
    private JComboBox<FlashDrive> flashDriveComboBox;
    private JPanel bootSelectionPanel;
    private JTextField bootSelectionTxt;
    private BFileChooser bootSelectionFileChooser;
    private JButton bootSelectionBtn;
    private JComboBox<PartitionSchemeType> partitionSchemeComboBox;
    private JComboBox<TargetSystemType> targetSystemComboBox;

    private JPanel formatPanel;
    private JLabel volumeNameLbl;
    private JLabel fileSystemLbl;
    private JLabel clusterSizeLbl;
    private JTextField volumeNameTxt;
    private JComboBox<FileSystemType> fileSystemComboBox;
    private JComboBox<ClusterSize> clusterSizeComboBox;

    private JPanel bottomPanel;
    private JProgressBar progressBar;
    private JButton startBtn;
    private JButton closeBtn;


    public JUSBViewImpl(String title) throws HeadlessException {
        super(title);
        init();
        setUp();
        build();
    }

    private void initContentPanel() {
        contentPanel = new JPanel(new MigLayout("wrap", "[grow, fill]"));
    }

    private void initDevicePanel() {
        devicePanel = new JPanel(new MigLayout("wrap 2", "[grow, fill] [grow, fill]"));
        flashDriveLbl = new JLabel("Flash drive");
        bootSelectionLbl = new JLabel("Boot selection");
        partitionSchemeLbl = new JLabel("Partition scheme");
        targetSystemLbl = new JLabel("Target system");
        bootSelectionPanel = new JPanel(new MigLayout("", "[grow, fill] [grow]"));
        flashDriveComboBox = new JComboBox<>();
        bootSelectionTxt = new JTextField();
        bootSelectionFileChooser = new BFileChooser();
        bootSelectionBtn = new JButton("", new ImageIcon("static/select.png"));
        partitionSchemeComboBox = new JComboBox<>();
        targetSystemComboBox = new JComboBox<>();
    }

    private void initFormatPanel() {
        formatPanel = new JPanel(new MigLayout("wrap 2", "[grow, fill] [grow, fill]"));
        volumeNameLbl = new JLabel("Volume");
        fileSystemLbl = new JLabel("File system");
        clusterSizeLbl = new JLabel("Cluster size");
        volumeNameTxt = new JTextField();
        fileSystemComboBox = new JComboBox<>();
        clusterSizeComboBox = new JComboBox<>();
    }

    private void initBottomPanel() {
        bottomPanel = new JPanel(new MigLayout("right", "[grow] [min!] [min!]"));
        progressBar = new JProgressBar();
        startBtn = new JButton("Start", new ImageIcon("static/racing-flag.png"));
        closeBtn = new JButton("Close", new ImageIcon("static/exit.png"));
    }

    @Override
    public void init() {
        initDevicePanel();
        initFormatPanel();
        initBottomPanel();
        initContentPanel();
    }

    private void setUpDevicePanel() {
        devicePanel.setBorder(BorderFactory.createTitledBorder("Device"));
    }

    private void setUpFormatPanel() {
        formatPanel.setBorder(BorderFactory.createTitledBorder("Format"));
    }

    private void setUpBottomPanel() {
        bottomPanel.setBorder(BorderFactory.createTitledBorder(""));
    }

    @Override
    public void setUp() {
        setUpDevicePanel();
        setUpFormatPanel();
        setUpBottomPanel();

        setContentPane(contentPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void buildDevicePanel() {
        bootSelectionPanel.add(bootSelectionTxt, "w 95%");
        bootSelectionPanel.add(bootSelectionBtn, "w 5%, align right");
        devicePanel.add(flashDriveLbl, "span");
        devicePanel.add(flashDriveComboBox, "span");
        devicePanel.add(bootSelectionLbl, "span");
        devicePanel.add(bootSelectionPanel, "span");
        devicePanel.add(partitionSchemeLbl, "");
        devicePanel.add(targetSystemLbl, "gapx 14");
        devicePanel.add(partitionSchemeComboBox, "");
        devicePanel.add(targetSystemComboBox, "gapx 14");
    }

    private void buildFormatPanel() {
        formatPanel.add(volumeNameLbl, "span");
        formatPanel.add(volumeNameTxt, "span");
        formatPanel.add(fileSystemLbl, "");
        formatPanel.add(clusterSizeLbl, "gapx 14");
        formatPanel.add(fileSystemComboBox);
        formatPanel.add(clusterSizeComboBox, "gapx 14");
    }

    private void buildBottomPanel() {
        bottomPanel.add(progressBar, "span 3, growx, wrap");
        bottomPanel.add(startBtn, "right");
        bottomPanel.add(closeBtn, "right");
    }

    private void _build() {
        contentPanel.add(devicePanel);
        contentPanel.add(formatPanel);
        contentPanel.add(bottomPanel);
    }

    @Override
    public void build() {
        buildDevicePanel();
        buildFormatPanel();
        buildBottomPanel();

        _build();
//        pack();
        setSize(new Dimension(400, 500));
        setLocationRelativeTo(null);
    }
    //----------------------------------


    @Override
    public void showException(Throwable throwable) {
        JOptionPane.showMessageDialog(null, throwable.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void setBootSelectionTxt(String fileName) {
        bootSelectionTxt.setText(fileName);
    }

    @Override
    public void setBootSelectionFileChooserVisible() {
        bootSelectionFileChooser.showOpenDialog(this);
    }

    @Override
    public void setStartBtnEnables(boolean enabled) {
        startBtn.setEnabled(enabled);
    }

    @Override
    public void whenUserClickStartButton(ButtonClickHandler startHandler) {
        startBtn.addActionListener(listener -> startHandler.click());
    }

    @Override
    public void whenUserClickCloseButton(ButtonClickHandler closeHandler) {
        closeBtn.addActionListener(listener -> closeHandler.click());
    }

    @Override
    public void whenUserClickBootSelectionButton(ButtonClickHandler bootSelectionHandler) {
        bootSelectionBtn.addActionListener(listener -> bootSelectionHandler.click());
    }

    @Override
    public void whenFileChooserSelectionChange(SelectionChangeHandler selectionChangeHandler) {
        bootSelectionFileChooser.addActionListener(listener -> selectionChangeHandler.selectionChange());
    }


    @Override
    public void setUSBComboBoxModel(BComboModel<FlashDrive> usbComboBoxModel) {
        flashDriveComboBox.setModel(usbComboBoxModel);
    }

    @Override
    public void setPartitionSchemeComboBoxModel(BComboModel<PartitionSchemeType> partitionSchemeTypeComboModel) {
        partitionSchemeComboBox.setModel(partitionSchemeTypeComboModel);
    }

    @Override
    public void setTargetSystemComboBoxModel(BComboModel<TargetSystemType> targetSystemTypeComboModel) {
        targetSystemComboBox.setModel(targetSystemTypeComboModel);
    }

    @Override
    public void setFileSystemComboBoxModel(BComboModel<FileSystemType> fileSystemComboBoxModel) {
        fileSystemComboBox.setModel(fileSystemComboBoxModel);
    }

    @Override
    public void setClusterComboBoxModel(BComboModel<ClusterSize> fileSystemComboBoxModel) {
        clusterSizeComboBox.setModel(fileSystemComboBoxModel);
    }

    @Override
    public void setFileChooserModel(BFileChooserModel fileChooserModel) {
        bootSelectionFileChooser.setFileChooserModel(fileChooserModel);
    }

    @Override
    public void setProgressBarModel(BProgressBarBoundedRangeModel boundedRangeModel) {
        progressBar.setModel(boundedRangeModel);
    }
}