/*******************************************************************************
 * (c) Copyright 2017 EntIT Software LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a 
 * copy of this software and associated documentation files (the 
 * "Software"), to deal in the Software without restriction, including without 
 * limitation the rights to use, copy, modify, merge, publish, distribute, 
 * sublicense, and/or sell copies of the Software, and to permit persons to 
 * whom the Software is furnished to do so, subject to the following 
 * conditions:
 * 
 * The above copyright notice and this permission notice shall be included 
 * in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY 
 * KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE 
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR 
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE 
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, 
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN 
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS 
 * IN THE SOFTWARE.
 ******************************************************************************/
package com.fortify.integration.sonarqube.ssc.configure;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import javax.swing.JComboBox;
import com.fortify.integration.sonarqube.ssc.config.MetricsConfig.MetricConfig;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import com.fortify.integration.sonarqube.ssc.config.MetricsConfig.MetricValueType;
import com.fortify.integration.sonarqube.ssc.config.MetricsConfig.Direction;
import javax.swing.DefaultComboBoxModel;

public class MetricDetailsPanel extends JPanel {

	private BindingGroup m_bindingGroup;
	private com.fortify.integration.sonarqube.ssc.config.MetricsConfig.MetricConfig metricConfig = new com.fortify.integration.sonarqube.ssc.config.MetricsConfig.MetricConfig();
	private JTextField nameJTextField;
	private JTextField domainJTextField;
	private JCheckBox qualitativeJCheckBox;
	private JTextField exprJTextField;
	private JTextArea descriptionJTextArea;
	private JLabel typeLabel;
	private JComboBox typeJComboBox;
	private JLabel directionLabel;
	private JComboBox directionJComboBox;

	public MetricDetailsPanel(com.fortify.integration.sonarqube.ssc.config.MetricsConfig.MetricConfig newMetricConfig) {
		this();
		setMetricConfig(newMetricConfig);
	}

	public MetricDetailsPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0E-4 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4 };
		setLayout(gridBagLayout);

		JLabel nameLabel = new JLabel("Name:");
		GridBagConstraints labelGbc_0 = new GridBagConstraints();
		labelGbc_0.anchor = GridBagConstraints.WEST;
		labelGbc_0.insets = new Insets(5, 5, 5, 5);
		labelGbc_0.gridx = 0;
		labelGbc_0.gridy = 0;
		add(nameLabel, labelGbc_0);

		nameJTextField = new JTextField();
		GridBagConstraints componentGbc_0 = new GridBagConstraints();
		componentGbc_0.insets = new Insets(5, 0, 5, 0);
		componentGbc_0.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_0.gridx = 1;
		componentGbc_0.gridy = 0;
		add(nameJTextField, componentGbc_0);
		
		typeLabel = new JLabel("Type:");
		GridBagConstraints gbc_typeLabel = new GridBagConstraints();
		gbc_typeLabel.anchor = GridBagConstraints.WEST;
		gbc_typeLabel.insets = new Insets(5, 5, 5, 5);
		gbc_typeLabel.gridx = 0;
		gbc_typeLabel.gridy = 1;
		add(typeLabel, gbc_typeLabel);
		
		typeJComboBox = new JComboBox();
		typeJComboBox.setModel(new DefaultComboBoxModel(MetricValueType.values()));
		GridBagConstraints gbc_typeJComboBox = new GridBagConstraints();
		gbc_typeJComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_typeJComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_typeJComboBox.gridx = 1;
		gbc_typeJComboBox.gridy = 1;
		add(typeJComboBox, gbc_typeJComboBox);

		JLabel domainLabel = new JLabel("Domain:");
		GridBagConstraints labelGbc_1 = new GridBagConstraints();
		labelGbc_1.anchor = GridBagConstraints.WEST;
		labelGbc_1.insets = new Insets(5, 5, 5, 5);
		labelGbc_1.gridx = 0;
		labelGbc_1.gridy = 2;
		add(domainLabel, labelGbc_1);

		domainJTextField = new JTextField();
		GridBagConstraints componentGbc_1 = new GridBagConstraints();
		componentGbc_1.insets = new Insets(5, 0, 5, 0);
		componentGbc_1.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_1.gridx = 1;
		componentGbc_1.gridy = 2;
		add(domainJTextField, componentGbc_1);
		
				JLabel exprLabel = new JLabel("Expr:");
				GridBagConstraints labelGbc_3 = new GridBagConstraints();
				labelGbc_3.anchor = GridBagConstraints.WEST;
				labelGbc_3.insets = new Insets(5, 5, 5, 5);
				labelGbc_3.gridx = 0;
				labelGbc_3.gridy = 3;
				add(exprLabel, labelGbc_3);
		
				exprJTextField = new JTextField();
				GridBagConstraints componentGbc_3 = new GridBagConstraints();
				componentGbc_3.insets = new Insets(5, 0, 5, 0);
				componentGbc_3.fill = GridBagConstraints.HORIZONTAL;
				componentGbc_3.gridx = 1;
				componentGbc_3.gridy = 3;
				add(exprJTextField, componentGbc_3);

		JLabel qualitativeLabel = new JLabel("Qualitative:");
		GridBagConstraints labelGbc_2 = new GridBagConstraints();
		labelGbc_2.anchor = GridBagConstraints.WEST;
		labelGbc_2.insets = new Insets(5, 5, 5, 5);
		labelGbc_2.gridx = 0;
		labelGbc_2.gridy = 4;
		add(qualitativeLabel, labelGbc_2);

		qualitativeJCheckBox = new JCheckBox();
		GridBagConstraints componentGbc_2 = new GridBagConstraints();
		componentGbc_2.insets = new Insets(5, 0, 5, 0);
		componentGbc_2.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_2.gridx = 1;
		componentGbc_2.gridy = 4;
		add(qualitativeJCheckBox, componentGbc_2);
		
		directionLabel = new JLabel("Direction:");
		GridBagConstraints gbc_directionLabel = new GridBagConstraints();
		gbc_directionLabel.anchor = GridBagConstraints.WEST;
		gbc_directionLabel.insets = new Insets(5, 5, 5, 5);
		gbc_directionLabel.gridx = 0;
		gbc_directionLabel.gridy = 5;
		add(directionLabel, gbc_directionLabel);
		
		directionJComboBox = new JComboBox();
		directionJComboBox.setModel(new DefaultComboBoxModel(Direction.values()));
		GridBagConstraints gbc_directionJComboBox = new GridBagConstraints();
		gbc_directionJComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_directionJComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_directionJComboBox.gridx = 1;
		gbc_directionJComboBox.gridy = 5;
		add(directionJComboBox, gbc_directionJComboBox);

		JLabel descriptionLabel = new JLabel("Description:");
		GridBagConstraints labelGbc_4 = new GridBagConstraints();
		labelGbc_4.anchor = GridBagConstraints.WEST;
		labelGbc_4.insets = new Insets(5, 5, 0, 5);
		labelGbc_4.gridx = 0;
		labelGbc_4.gridy = 6;
		add(descriptionLabel, labelGbc_4);

		descriptionJTextArea = new JTextArea();
		descriptionJTextArea.setRows(5);
		GridBagConstraints componentGbc_4 = new GridBagConstraints();
		componentGbc_4.insets = new Insets(5, 0, 0, 0);
		componentGbc_4.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_4.gridx = 1;
		componentGbc_4.gridy = 6;
		add(descriptionJTextArea, componentGbc_4);

		if (metricConfig != null) {
			m_bindingGroup = initDataBindings();
		}
	}

	public com.fortify.integration.sonarqube.ssc.config.MetricsConfig.MetricConfig getMetricConfig() {
		return metricConfig;
	}

	public void setMetricConfig(
			com.fortify.integration.sonarqube.ssc.config.MetricsConfig.MetricConfig newMetricConfig) {
		setMetricConfig(newMetricConfig, true);
	}

	public void setMetricConfig(com.fortify.integration.sonarqube.ssc.config.MetricsConfig.MetricConfig newMetricConfig,
			boolean update) {
		metricConfig = newMetricConfig;
		if (update) {
			if (m_bindingGroup != null) {
				m_bindingGroup.unbind();
				m_bindingGroup = null;
			}
			if (metricConfig != null) {
				m_bindingGroup = initDataBindings();
			}
		}
	}
	protected BindingGroup initDataBindings() {
		BeanProperty<MetricConfig, String> nameProperty = BeanProperty.create("name");
		BeanProperty<JTextField, String> textProperty = BeanProperty.create("text");
		AutoBinding<MetricConfig, String, JTextField, String> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, metricConfig, nameProperty, nameJTextField, textProperty);
		autoBinding.bind();
		//
		BeanProperty<MetricConfig, String> domainProperty = BeanProperty.create("domain");
		BeanProperty<JTextField, String> textProperty_1 = BeanProperty.create("text");
		AutoBinding<MetricConfig, String, JTextField, String> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, metricConfig, domainProperty, domainJTextField, textProperty_1);
		autoBinding_1.bind();
		//
		BeanProperty<MetricConfig, Boolean> qualitativeProperty = BeanProperty.create("qualitative");
		BeanProperty<JCheckBox, Boolean> selectedProperty = BeanProperty.create("selected");
		AutoBinding<MetricConfig, Boolean, JCheckBox, Boolean> autoBinding_2 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, metricConfig, qualitativeProperty, qualitativeJCheckBox, selectedProperty);
		autoBinding_2.bind();
		//
		BeanProperty<MetricConfig, String> exprProperty = BeanProperty.create("expr");
		BeanProperty<JTextField, String> textProperty_2 = BeanProperty.create("text");
		AutoBinding<MetricConfig, String, JTextField, String> autoBinding_3 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, metricConfig, exprProperty, exprJTextField, textProperty_2);
		autoBinding_3.bind();
		//
		BeanProperty<MetricConfig, String> descriptionProperty = BeanProperty.create("description");
		BeanProperty<JTextArea, String> textProperty_3 = BeanProperty.create("text");
		AutoBinding<MetricConfig, String, JTextArea, String> autoBinding_4 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, metricConfig, descriptionProperty, descriptionJTextArea, textProperty_3);
		autoBinding_4.bind();
		//
		BeanProperty<MetricConfig, MetricValueType> metricConfigBeanProperty = BeanProperty.create("type");
		BeanProperty<JComboBox, Object> jComboBoxBeanProperty = BeanProperty.create("selectedItem");
		AutoBinding<MetricConfig, MetricValueType, JComboBox, Object> autoBinding_5 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, metricConfig, metricConfigBeanProperty, typeJComboBox, jComboBoxBeanProperty);
		autoBinding_5.bind();
		//
		BeanProperty<MetricConfig, Direction> metricConfigBeanProperty_1 = BeanProperty.create("direction");
		AutoBinding<MetricConfig, Direction, JComboBox, Object> autoBinding_6 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, metricConfig, metricConfigBeanProperty_1, directionJComboBox, jComboBoxBeanProperty);
		autoBinding_6.bind();
		//
		BindingGroup bindingGroup = new BindingGroup();
		//
		bindingGroup.addBinding(autoBinding);
		bindingGroup.addBinding(autoBinding_1);
		bindingGroup.addBinding(autoBinding_2);
		bindingGroup.addBinding(autoBinding_3);
		bindingGroup.addBinding(autoBinding_4);
		bindingGroup.addBinding(autoBinding_5);
		bindingGroup.addBinding(autoBinding_6);
		return bindingGroup;
	}
}
