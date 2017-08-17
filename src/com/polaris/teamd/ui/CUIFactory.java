package com.polaris.teamd.ui;

import static com.polaris.teamd.ui.CUIComponentType.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import javax.security.auth.login.AppConfigurationEntry;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import com.polaris.teamd.app.ApplicationCache;
import com.polaris.teamd.common.PropertyFileProcessing;
import com.polaris.teamd.common.validations.CValidator;
import com.polaris.teamd.common.utils.UIDateUtil;
import com.polaris.teamd.common.utils.UIUtil;
import com.polaris.teamd.ui.custom.inputpanel.CComboInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CDatePickerInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CEditorOutputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CEmptyPanel;
import com.polaris.teamd.ui.custom.inputpanel.CFilterTableInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CMultiCheckInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CMultiTextInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CPasswordInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CRadioGroupInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CSingleSelectInputTablePanel;
import com.polaris.teamd.ui.custom.inputpanel.CSingleSelectListInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CSpinnerInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CTextInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CTextOutputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CValidatingListener;
import com.polaris.teamd.ui.custom.CActionPanel;
import com.polaris.teamd.ui.custom.CButton;
import com.polaris.teamd.ui.custom.CCheck;
import com.polaris.teamd.ui.custom.CCombo;
import com.polaris.teamd.ui.custom.CEditorPane;
import com.polaris.teamd.ui.custom.CError;
import com.polaris.teamd.ui.custom.CErrors;
import com.polaris.teamd.ui.custom.CForm;
import com.polaris.teamd.ui.custom.CFormHeader;
import com.polaris.teamd.ui.custom.CInfo;
import com.polaris.teamd.ui.custom.CLabel;
import com.polaris.teamd.ui.custom.CList;
import com.polaris.teamd.ui.custom.CMenuButton;
import com.polaris.teamd.ui.custom.CMultiCheck;
import com.polaris.teamd.ui.custom.CMultiText;
import com.polaris.teamd.ui.custom.CPassword;
import com.polaris.teamd.ui.custom.CRadio;
import com.polaris.teamd.ui.custom.CRadioGroup;
import com.polaris.teamd.ui.custom.CSingleSelectInputTable;
import com.polaris.teamd.ui.custom.CSingleSelectList;
import com.polaris.teamd.ui.custom.CSpinner;
import com.polaris.teamd.ui.custom.CTable;
import com.polaris.teamd.ui.custom.CText;
import com.polaris.teamd.ui.custom.CTextArea;
import com.polaris.teamd.ui.custom.CToolBar;
import com.polaris.teamd.ui.custom.CWizard;
import com.polaris.teamd.ui.custom.CWizard1;

public class CUIFactory<E> {

	private JComponent jcomponent;
	private CValidatingListener cValidatingListener = new CValidatingListener();
	private PropertyFileProcessing inputPanelProcessor = new PropertyFileProcessing();
	private String targetBean, targetBeanProperty, sourceBean,
			sourceBeanProperty, panelType;

	public JComponent createUIComponent(int componentType) {
		switch (componentType) {

		case LABEL:
			jcomponent = new CLabel();
			break;
		case TEXT:
			jcomponent = new CText();
			break;
		case TEXTAREA:
			jcomponent = new CTextArea();
			break;

		case MULTITEXT:
			jcomponent = new CMultiText();
			break;
		case CHECKBOX:
			jcomponent = new CCheck();
			break;
		case RADIO:
			jcomponent = new CRadio();
			break;
		case LIST:
			jcomponent = new CList();
			break;
		case COMBOBOX:
			jcomponent = new CCombo();
			break;
		case SPINNER:
			jcomponent = new CSpinner();
			break;
		case TABLE:
			jcomponent = new CTable();
			break;
		case BUTTON:
			jcomponent = new CButton();
			break;
		case ERROR:
			jcomponent = new CError();
			break;
		case INFO:
			jcomponent = new CInfo();
			break;
		case ERRORS:
			jcomponent = new CErrors();
			break;
		case FORMHEADER:
			jcomponent = new CFormHeader();
			break;
		case MENUBUTTON:
			jcomponent = new CMenuButton();
			break;
		case FORM:
			jcomponent = new CForm();
			break;
		case WIZARD:
			jcomponent = new CWizard();
			break;
		case TOOLBAR:
			jcomponent = new CToolBar();
			break;
		case RADIOGROUP:
			jcomponent = new CRadioGroup();
			break;
		case MULTICHECKBOX:
			jcomponent = new CMultiCheck();
			break;
		case ACTIONPANEL:
			jcomponent = new CActionPanel();
			break;
		case SINGLESELECTLIST:
			jcomponent = new CSingleSelectList<E>();
			break;
		case PASSWORD:
			jcomponent = new CPassword();
			break;
		case EDITORPANE:
			jcomponent = new CEditorPane();
		case MANDATORYINDICATOR:
			jcomponent = new CLabel("*");
			jcomponent.setFont(UIUtil.getFont("Arial", 25));
		case SINGLESELECTINPUTTABLE:
			jcomponent = new CSingleSelectInputTable();
			break;

		default:
			break;
		}
		return jcomponent;
	}

	public JComponent applyBorder(JComponent component) {

		Border border = UIUtil.createSimpleBorder();
		component.setBorder(border);
		return component;

	}

	public JComponent setUI(JComponent component) {
		PropertyFileProcessing processor = new PropertyFileProcessing();
		processor.setPropertyFile(new File("resources/ui/ui.properties"));
		String fontName = processor.getStringProperty("ui.font.name");
		int fontSize = processor.getIntProperty("ui.font.size");
		String fontStyle = processor.getStringProperty("ui.font.style");
		int styleOfFont = -1;
		if (fontStyle.equals("PLAIN"))
			styleOfFont = 0;
		if (fontStyle.equals("BOLD"))
			styleOfFont = 1;
		if (fontStyle.equals("ITALIC"))
			styleOfFont = 2;
		component.setFont(new Font(fontName, styleOfFont, fontSize));
		return component;

	}

	public CForm setFormUI(CForm cForm) {
		CFormHeader formHeader = cForm.getCFormHeader();
		CLabel status = cForm.getStatus();
		CButton closeButton = cForm.getCloseButton();
		JPanel formFooter = cForm.getcFormFooter();

		PropertyFileProcessing processor = new PropertyFileProcessing();
		processor.setPropertyFile(new File("resources/ui/ui.properties"));

		String fontName = processor
				.getStringProperty("ui.form.heading.font.name");
		int fontSize = processor.getIntProperty("ui.form.heading.font.size");
		String fontStyle = processor
				.getStringProperty("ui.form.heading.font.style");

		int backgroundRed = processor
				.getIntProperty("ui.form.heading.backgroundColor.red");
		int backgroundGreen = processor
				.getIntProperty("ui.form.heading.backgroundColor.green");
		int backgroundBlue = processor
				.getIntProperty("ui.form.heading.backgroundColor.blue");

		int foregroundRed = processor
				.getIntProperty("ui.form.heading.foregroundColor.red");
		int foregroundGreen = processor
				.getIntProperty("ui.form.heading.foregroundColor.green");
		int foregroundBlue = processor
				.getIntProperty("ui.form.heading.foregroundColor.blue");

		int formHeadingWidth = processor
				.getIntProperty("ui.form.heading.width.default");
		int formHeadingHeight = processor
				.getIntProperty("ui.form.heading.height.default");

		int styleOfFont = -1;
		if (fontStyle.equals("PLAIN"))
			styleOfFont = 0;
		if (fontStyle.equals("BOLD"))
			styleOfFont = 1;
		if (fontStyle.equals("ITALIC"))
			styleOfFont = 2;

		formHeader.getLabel()
				.setFont(new Font(fontName, styleOfFont, fontSize));
		formHeader.setBackground(new Color(backgroundRed, backgroundGreen,
				backgroundBlue));
		formHeader.getLabel().setForeground(
				new Color(foregroundRed, foregroundGreen, foregroundBlue));

		formHeader.setPreferredSize(new Dimension(formHeadingWidth,
				formHeadingHeight));
		formHeader.setMaximumSize(new Dimension(formHeadingWidth,
				formHeadingHeight));
		formHeader.setMinimumSize(new Dimension(formHeadingWidth,
				formHeadingHeight));
		formHeader.setSize(new Dimension(formHeadingWidth, formHeadingHeight));

		String fontName1 = processor
				.getStringProperty("ui.form.status.font.name");
		int fontSize1 = processor.getIntProperty("ui.form.status.font.size");
		String fontStyle1 = processor
				.getStringProperty("ui.form.status.font.style");

		int backgroundRed1 = processor
				.getIntProperty("ui.form.status.backgroundColor.red");
		int backgroundGreen1 = processor
				.getIntProperty("ui.form.status.backgroundColor.green");
		int backgroundBlue1 = processor
				.getIntProperty("ui.form.status.backgroundColor.blue");

		int foregroundRed1 = processor
				.getIntProperty("ui.form.status.foregroundColor.red");
		int foregroundGreen1 = processor
				.getIntProperty("ui.form.status.foregroundColor.green");
		int foregroundBlue1 = processor
				.getIntProperty("ui.form.status.foregroundColor.blue");

		int formHeadingWidth1 = processor
				.getIntProperty("ui.form.status.width.default");
		int formHeadingHeight1 = processor
				.getIntProperty("ui.form.status.height.default");

		int styleOfFont1 = -1;
		if (fontStyle1.equals("PLAIN"))
			styleOfFont1 = 0;
		if (fontStyle1.equals("BOLD"))
			styleOfFont1 = 1;
		if (fontStyle1.equals("ITALIC"))
			styleOfFont1 = 2;

		status.setFont(new Font(fontName1, styleOfFont1, fontSize1));
		formFooter.setBackground(new Color(backgroundRed1, backgroundGreen1,
				backgroundBlue1));
		status.setForeground(new Color(foregroundRed1, foregroundGreen1,
				foregroundBlue1));

		formFooter.setPreferredSize(new Dimension(formHeadingWidth1,
				formHeadingHeight1));
		formFooter.setMaximumSize(new Dimension(formHeadingWidth1,
				formHeadingHeight1));
		formFooter.setMinimumSize(new Dimension(formHeadingWidth1,
				formHeadingHeight1));
		formFooter
				.setSize(new Dimension(formHeadingWidth1, formHeadingHeight1));

		String fontName11 = processor
				.getStringProperty("ui.form.status.font.name");
		int fontSize11 = processor.getIntProperty("ui.form.status.font.size");
		String fontStyle11 = processor
				.getStringProperty("ui.form.status.font.style");

		int backgroundRed11 = processor
				.getIntProperty("ui.form.status.backgroundColor.red");
		int backgroundGreen11 = processor
				.getIntProperty("ui.form.status.backgroundColor.green");
		int backgroundBlue11 = processor
				.getIntProperty("ui.form.status.backgroundColor.blue");

		int backgroundRed12 = processor
				.getIntProperty("ui.form.button.backgroundColor.red");
		int backgroundGreen12 = processor
				.getIntProperty("ui.form.button.backgroundColor.green");
		int backgroundBlue12 = processor
				.getIntProperty("ui.form.button.backgroundColor.blue");

		int foregroundRed11 = processor
				.getIntProperty("ui.form.status.foregroundColor.red");
		int foregroundGreen11 = processor
				.getIntProperty("ui.form.status.foregroundColor.green");
		int foregroundBlue11 = processor
				.getIntProperty("ui.form.status.foregroundColor.blue");

		int formHeadingWidth11 = processor
				.getIntProperty("ui.form.status.width.default");
		int formHeadingHeight11 = processor
				.getIntProperty("ui.form.status.height.default");

		int styleOfFont11 = -1;
		if (fontStyle11.equals("PLAIN"))
			styleOfFont11 = 0;
		if (fontStyle11.equals("BOLD"))
			styleOfFont11 = 1;
		if (fontStyle11.equals("ITALIC"))
			styleOfFont11 = 2;

		closeButton.setFont(new Font(fontName11, styleOfFont11, fontSize11));
		closeButton.setBackground(new Color(backgroundRed12, backgroundGreen12,
				backgroundBlue12));
		closeButton.setForeground(new Color(foregroundRed11, foregroundGreen11,
				foregroundBlue11));

		closeButton.setPreferredSize(new Dimension(formHeadingWidth11,
				formHeadingHeight11));
		closeButton.setMaximumSize(new Dimension(formHeadingWidth11,
				formHeadingHeight11));
		closeButton.setMinimumSize(new Dimension(formHeadingWidth11,
				formHeadingHeight11));
		closeButton.setSize(new Dimension(formHeadingWidth11,
				formHeadingHeight11));

		return cForm;

	}

	public JComponent setAnimation(MouseListener mouseListener,
			JComponent jComponent) {
		jComponent.addMouseListener(mouseListener);
		return jComponent;
	}

	public JComponent setValidators(CForm cForm, String fileName) {
		Properties properties = new Properties();
		try {
			InputStream inputStream = new FileInputStream(fileName);
			properties.load(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Set<String> set = properties.stringPropertyNames();
		ArrayList<String> propertyList = new ArrayList<String>(set);
		Collections.sort(propertyList);
		int index = 0;
		ArrayList<JPanel> cInputPanels = cForm.cGetInputPanels();
		for (String string : propertyList) {
			if (string.endsWith("validatorName")) {
				String[] parts = string.split("\\.");
				if ((Integer.parseInt(parts[1])) == (index + 1)) {
					JPanel panel = cInputPanels.get(index);
					index++;
					try {
						if (!(properties.getProperty(string)).equals("nil")) {
							cValidatingListener.addValidator((CValidator) Class
									.forName(properties.getProperty(string))
									.newInstance());
							// panel.addValidators(cValidatingListener);
						}
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			}

		}

		return cForm;
	}

	public void setBeanAndProperties(String fileName) {
		inputPanelProcessor.setPropertyFile(new File(fileName));
		targetBean = inputPanelProcessor
				.getStringProperty("form.inputpanel.target.bean");
		targetBeanProperty = inputPanelProcessor
				.getStringProperty("form.inputpanel.target.bean.property");
		panelType = inputPanelProcessor
				.getStringProperty("form.inputpanel.input.type");
		sourceBean = inputPanelProcessor
				.getStringProperty("form.inputpanel.source.bean");
		sourceBeanProperty = inputPanelProcessor
				.getStringProperty("form.inputpanel.source.bean.property");
	}

	public CForm createForm(String fileName) {
		CForm cForm = (CForm) createUIComponent(CUIComponentType.FORM);
		JPanel cInputPanel = null;
		inputPanelProcessor.setPropertyFile(new File(fileName));
		String formHeading = inputPanelProcessor
				.getStringProperty("form.head.string");
		System.out.println(formHeading);
		cForm.cInit(formHeading);
		String statusCaption = inputPanelProcessor
				.getStringProperty("form.status.string");
		// cForm.cSetStatus(statusCaption);
		int formWidth = inputPanelProcessor.getIntProperty("form.size.width");
		int formHeight = inputPanelProcessor.getIntProperty("form.size.height");
		cForm.setPreferredSize(new Dimension(formWidth, formHeight));
		cForm.setMinimumSize(new Dimension(formWidth, formHeight));
		cForm.setMaximumSize(new Dimension(formWidth, formHeight));
		cForm.setSize(formWidth, formHeight);

		String[] inputPanelFiles = inputPanelProcessor
				.getIndexedPropertyValues("file");
		for (int i = 0; i < inputPanelFiles.length; i++) {
			inputPanelProcessor.setPropertyFile(new File(inputPanelFiles[i]));
			String panelType = inputPanelProcessor
					.getStringProperty("form.inputpanel.type");
			if (panelType
					.equals("com.polaris.teamd.ui.custom.inputpanel.CComboInputPanel")) {
				CComboInputPanel cComboInputPanel = createComboPanel();
				cComboInputPanel.init();
				cComboInputPanel = setComboUI(inputPanelFiles[i],
						cComboInputPanel);
				// cComboInputPanel.setParameters();
				cForm.cAddInputPanel(cComboInputPanel);
			}
			if (panelType
					.equals("com.polaris.teamd.ui.custom.inputpanel.CEmptyPanel")) {
				CEmptyPanel cEmptyPanel = createEmptyPanel();
				cEmptyPanel = setEmptyPanelUI(cEmptyPanel, inputPanelFiles[i]);
				cForm.cAddInputPanel(cEmptyPanel);
			}
			if (panelType
					.equals("com.polaris.teamd.ui.custom.inputpanel.CSingleSelectListInputPanel")) {
				CSingleSelectListInputPanel cSingleSelectListInputPanel = createListInputPanel();
				cSingleSelectListInputPanel.init();
				cSingleSelectListInputPanel = setListInputPanelUI(
						cSingleSelectListInputPanel, inputPanelFiles[i]);
				cForm.cAddInputPanel(cSingleSelectListInputPanel);
			}
			if (panelType
					.equals("com.polaris.teamd.ui.custom.inputpanel.CRadioGroupInputPanel")) {
				CRadioGroupInputPanel cRadioGroupInputPanel = createRadioGroupPanel();
				cRadioGroupInputPanel.init();
				cRadioGroupInputPanel = setRadioGroupUI(inputPanelFiles[i],
						cRadioGroupInputPanel);
				cForm.cAddInputPanel(cRadioGroupInputPanel);
			}
			if (panelType
					.equals("com.polaris.teamd.ui.custom.inputpanel.CMultiCheckInputPanel")) {
				CMultiCheckInputPanel cMultiCheckInputPanel = createMultiCheckPanel();
				cMultiCheckInputPanel.cInit();
				cMultiCheckInputPanel = setMultiCheckUI(inputPanelFiles[i],
						cMultiCheckInputPanel);
				// cMultiCheckInputPanel.setParameters();
				cForm.cAddInputPanel(cMultiCheckInputPanel);
			}
			if (panelType
					.equals("com.polaris.teamd.ui.custom.inputpanel.CTextInputPanel")) {
				CTextInputPanel textPanel = createTextInputPanel();
				textPanel.init();
				textPanel = setTextInputPanelUI(textPanel, inputPanelFiles[i]);
				cForm.cAddInputPanel(textPanel);
			}
			if (panelType
					.equals("com.polaris.teamd.ui.custom.inputpanel.CSpinnerInputPanel")) {
				CSpinnerInputPanel cSpinnerInputPanel = createSpinnerPanel();
				cSpinnerInputPanel.init();
				cSpinnerInputPanel = setSpinnerUI(inputPanelFiles[i],
						cSpinnerInputPanel);
				// cSpinnerInputPanel.setComponentAttributes();
				cForm.cAddInputPanel(cSpinnerInputPanel);
			}
			if (panelType.equals("com.polaris.teamd.ui.custom.CActionPanel")) {
				CActionPanel actionPanel = createActionPanel();
				actionPanel = setActionPanelUI(actionPanel, inputPanelFiles[i]);
				actionPanel.setComponentAttributes();
				cForm.cAddInputPanel(actionPanel);
			}
			if (panelType
					.equals("com.polaris.teamd.ui.custom.inputpanel.CPasswordInputPanel")) {
				CPasswordInputPanel cPasswordInputPanel = createPasswordPanel();
				cPasswordInputPanel.cInit();
				cPasswordInputPanel = setPasswordUI(inputPanelFiles[i],
						cPasswordInputPanel);
				System.out.println(cPasswordInputPanel.cGetCaptionLabel());
				cForm.cAddInputPanel(cPasswordInputPanel);
			}

			if (panelType
					.equals("com.polaris.teamd.ui.custom.inputpanel.CFilterTableInputPanel")) {
				CFilterTableInputPanel tableInputPanel = createFilterTablePanel();
				tableInputPanel.cInit();
				cForm.cAddInputPanel(tableInputPanel);
			}
			if (panelType
					.equals("com.polaris.teamd.ui.custom.inputpanel.CEditorOutputPanel")) {
				CEditorOutputPanel cEditorOutputPanel = createCEditorOutputPanel();
				cEditorOutputPanel.init();
				cEditorOutputPanel = setEditorPanelUI(inputPanelFiles[i],
						cEditorOutputPanel);
				cForm.cAddInputPanel(cEditorOutputPanel);
			}
			if (panelType
					.equals("com.polaris.teamd.ui.custom.inputpanel.CSingleSelectInputTablePanel")) {
				CSingleSelectInputTablePanel tablePanel = createSingleSelectTablePanel();
				tablePanel.cInit();
				setTableUI(tablePanel, inputPanelFiles[i]);
				cForm.cAddInputPanel(tablePanel);
			}
			if (panelType
					.equals("com.polaris.teamd.ui.custom.inputpanel.CTextOutputPanel")) {
				CTextOutputPanel textPanel = createTextOutputPanel();
				textPanel.init();
				textPanel = setTextOutputPanelUI(textPanel, inputPanelFiles[i]);
				// textPanel.setParameters();
				cForm.cAddInputPanel(textPanel);
			}
			if (panelType
					.equals("com.polaris.teamd.ui.custom.inputpanel.CMultiTextPanel")) {
				CMultiTextInputPanel cMultiTextInputPanel = createMultiTextPanel();
				cMultiTextInputPanel.init();
				cMultiTextInputPanel = setMultiTextUI(inputPanelFiles[i],
						cMultiTextInputPanel);
				cForm.cAddInputPanel(cMultiTextInputPanel);
			}

			if (panelType
					.equals("com.polaris.teamd.ui.custom.inputpanel.CDatePickerInputPanel")) {
				CDatePickerInputPanel cDatePickerPanel = createDatePickerInputPanel();
				cDatePickerPanel.init();
				cDatePickerPanel = setDatePickerUI(inputPanelFiles[i],
						cDatePickerPanel);
				cForm.cAddInputPanel(cDatePickerPanel);
			}
			
			if (panelType.equals("com.polaris.teamd.ui.custom.CForm")) {
				CForm cForm2 = createForm(inputPanelFiles[i]);
				cForm2 = setFormUI(cForm2);
				cForm2 = (CForm) applyBorder(cForm2);
				cForm.cAddInputPanel(cForm2);
			}
			// cForm.cAddInputPanel(cInputPanel);
			System.out.println(i);
			// System.out.println(cInputPanel);
		}
		cForm = (CForm) applyBorder(cForm);
		return cForm;
	}

	public boolean isSetBeanDefined(String sourceBean, String sourceBeanProperty) {

		Class beanClassType = null;
		String panelType = null;
		if (((sourceBean != null)) && sourceBeanProperty != null) {
			beanClassType = getClassType(sourceBean, sourceBeanProperty);
			panelType = inputPanelProcessor
					.getStringProperty("form.inputpanel.input.type");

		}
		return beanClassType.toString().equals(panelType);
	}

	public Method getGetterMethod(Object object, String sourceBeanProperty) {
		StringBuffer stringBuffer = new StringBuffer();
		// Object object = ApplicationCache.getValue(sourceBean);
		Class class1 = object.getClass();
		stringBuffer.append("get")
				.append(Character.toUpperCase(sourceBeanProperty.charAt(0)))
				.append(sourceBeanProperty.substring(1));
		Method method = null;
		try {
			method = class1.getMethod(stringBuffer.toString());
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return method;
	}

	public Class getClassType(String sourceBean, String sourceBeanProperty) {

		Object object = ApplicationCache.getValue(sourceBean);
		Method method = getGetterMethod(object, sourceBeanProperty);
		Class typeOfMethod = method.getReturnType();

		return typeOfMethod;
	}

	public Object generateBeanGetterValue(String sourceBean,
			String sourceBeanProperty) {

		Method method = getGetterMethod(ApplicationCache.getValue(sourceBean),
				sourceBeanProperty);
		Object invokeObject = ApplicationCache.getValue(sourceBean);
		Object getterValue = null;
		try {
			getterValue = method.invoke(invokeObject);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return getterValue;
	}

	public Object[] getObjectsForListSource() {
		String listSource = inputPanelProcessor
				.getStringProperty("form.inputpanel.listsource");
		String[] separatedStrings = listSource.split("\\.");

		int separatedLength = (separatedStrings.length);
		String listSourceMethod = separatedStrings[separatedLength - 1];
		StringBuffer stringBuffer = new StringBuffer();

		for (int i = 0; i <= separatedLength - 2; i++) {
			if (i == (separatedLength - 2))
				stringBuffer.append(separatedStrings[i]);
			else
				stringBuffer.append(separatedStrings[i]).append(".");
		}

		String listClass = stringBuffer.toString();

		Class class1;
		Method method;
		ArrayList objectsList;
		Object[] listOfObjects = null;
		try {
			class1 = Class.forName(listClass);
			method = class1.getMethod(listSourceMethod);
			objectsList = (ArrayList) method.invoke(class1.newInstance());
			listOfObjects = objectsList.toArray();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		return listOfObjects;
	}

	public CInputPanel setValidators(CInputPanel cInputPanel, String fileName) {
		// System.out.println(inputPanelProcessor.get);
		inputPanelProcessor.setPropertyFile(new File(fileName));
		String[] validatorNames = inputPanelProcessor
				.getIndexedPropertyValues("validator.class");
		String minValue, maxValue, minLength, maxLength, minValueType, maxValueType, minLengthType, maxLengthType;

		int index = 0;
		for (String validatorClass : validatorNames) {
			if (validatorClass
					.equals("com.polaris.teamd.common.validations.CDateMaxValueValidator")) {
				maxValue = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.maxvalue");
				maxValueType = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.maxvalue.type");
				try {
					Class class1 = Class
							.forName("com.polaris.teamd.common.validations.CDateMaxValueValidator");
					Object object = class1.newInstance();
					Method method = class1.getMethod("setMaxDate",
							(new Date()).getClass());
					method.invoke(object, UIDateUtil.convertStringToDate(
							maxValue, "dd/MM/yyyy"));
					cValidatingListener.addValidator((CValidator) object);
					cInputPanel.addValidators(cValidatingListener);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			if (validatorClass
					.equals("com.polaris.teamd.common.validations.CDateMinValueValidator")) {
				minValue = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.minvalue");
				minValueType = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.minvalue.type");

				try {
					Class class1 = Class
							.forName("com.polaris.teamd.common.validations.CDateMinValueValidator");
					Object object = class1.newInstance();
					Method method = class1.getMethod("setMinDate",
							(new Date()).getClass());
					method.invoke(object, UIDateUtil.convertStringToDate(
							minValue, "dd/MM/yyyy"));
					cValidatingListener.addValidator((CValidator) object);
					cInputPanel.addValidators(cValidatingListener);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			if (validatorClass
					.equals("com.polaris.teamd.common.validations.CDateValueRangeValidator")) {
				maxValue = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.maxvalue");
				maxValueType = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.maxvalue.type");
				minValue = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.minvalue");
				minValueType = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.minvalue.type");

				try {
					Class class1 = Class
							.forName("com.polaris.teamd.common.validations.CDateValueRangeValidator");
					Object object = class1.newInstance();
					Method method = class1.getMethod("setMinDate",
							(new Date()).getClass());
					method.invoke(object, UIDateUtil.convertStringToDate(
							minValue, "dd/MM/yyyy"));

					method = class1.getMethod("setMaxDate",
							(new Date()).getClass());
					method.invoke(object, UIDateUtil.convertStringToDate(
							maxValue, "dd/MM/yyyy"));
					cValidatingListener.addValidator((CValidator) object);
					cInputPanel.addValidators(cValidatingListener);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			if (validatorClass
					.equals("com.polaris.teamd.common.validations.CDoubleMaximumValueValidator")) {
				maxValue = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.maxvalue");
				maxValueType = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.maxvalue.type");

				try {
					Class class1 = Class
							.forName("com.polaris.teamd.common.validations.CDoubleMaximumValueValidator");
					Object object = class1.newInstance();
					Method method = class1.getMethod("setMaximumDataValue",
							double.class);
					method.invoke(object, Double.parseDouble(maxValue));
					cValidatingListener.addValidator((CValidator) object);
					cInputPanel.addValidators(cValidatingListener);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}

			if (validatorClass
					.equals("com.polaris.teamd.common.validations.CDoubleMinimumValueValidator")) {
				minValue = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.minvalue");
				minValueType = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.minvalue.type");

				try {
					Class class1 = Class
							.forName("com.polaris.teamd.common.validations.CDoubleMinimumValueValidator");
					Object object = class1.newInstance();
					Method method = class1.getMethod("setMinimumDataValue",
							double.class);
					method.invoke(object, Double.parseDouble(minValue));
					cValidatingListener.addValidator((CValidator) object);
					cInputPanel.addValidators(cValidatingListener);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}

			if (validatorClass
					.equals("com.polaris.teamd.common.validations.CDoubleValueRangeValidator")) {
				maxValue = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.maxvalue");
				maxValueType = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.maxvalue.type");
				minValue = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.minvalue");
				minValueType = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.minvalue.type");

				try {
					Class class1 = Class
							.forName("com.polaris.teamd.common.validations.CDoubleValueRangeValidator");
					Object object = class1.newInstance();
					Method method = class1.getMethod("setMinValue",
							double.class);
					method.invoke(object, Double.parseDouble(minValue));

					method = class1.getMethod("setMaxValue", double.class);
					method.invoke(object, Double.parseDouble(maxValue));
					cValidatingListener.addValidator((CValidator) object);
					cInputPanel.addValidators(cValidatingListener);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}

			if (validatorClass
					.equals("com.polaris.teamd.common.validations.CFloatMaximumValueValidator")) {
				maxValue = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.maxvalue");
				maxValueType = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.maxvalue.type");

				try {
					Class class1 = Class
							.forName("com.polaris.teamd.common.validations.CFloatMaximumValueValidator");
					Object object = class1.newInstance();
					Method method = class1.getMethod("setMaximumDataValue",
							float.class);
					method.invoke(object, Float.parseFloat(maxValue));
					cValidatingListener.addValidator((CValidator) object);
					cInputPanel.addValidators(cValidatingListener);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}

			if (validatorClass
					.equals("com.polaris.teamd.common.validations.CFloatMinimumValueValidator")) {
				minValue = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.minvalue");
				minValueType = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.minvalue.type");

				try {
					Class class1 = Class
							.forName("com.polaris.teamd.common.validations.CFloatMinimumValueValidator");
					Object object = class1.newInstance();
					Method method = class1.getMethod("setMinimumDataValue",
							float.class);
					method.invoke(object, Float.parseFloat(minValue));
					cValidatingListener.addValidator((CValidator) object);
					cInputPanel.addValidators(cValidatingListener);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}

			if (validatorClass
					.equals("com.polaris.teamd.common.validations.CFloatValueRangeValidator")) {
				maxValue = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.maxvalue");
				maxValueType = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.maxvalue.type");
				minValue = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.minvalue");
				minValueType = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.minvalue.type");

				try {
					Class class1 = Class
							.forName("com.polaris.teamd.common.validations.CFloatValueRangeValidator");
					Object object = class1.newInstance();
					Method method = class1
							.getMethod("setMinValue", float.class);
					method.invoke(object, Float.parseFloat(minValue));

					method = class1.getMethod("setMaxValue", float.class);
					method.invoke(object, Float.parseFloat(maxValue));
					cValidatingListener.addValidator((CValidator) object);
					cInputPanel.addValidators(cValidatingListener);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}

			if (validatorClass
					.equals("com.polaris.teamd.common.validations.CIntMaximumValueValidator")) {
				maxValue = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.maxvalue");
				maxValueType = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.maxvalue.type");

				try {
					Class class1 = Class
							.forName("com.polaris.teamd.common.validations.CIntMaximumValueValidator");
					Object object = class1.newInstance();
					Method method = class1.getMethod("setMaximumDataValue",
							int.class);
					method.invoke(object, Integer.parseInt(maxValue));
					cValidatingListener.addValidator((CValidator) object);
					cInputPanel.addValidators(cValidatingListener);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			if (validatorClass
					.equals("com.polaris.teamd.common.validations.CIntMinimumValueValidator")) {
				minValue = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.minvalue");
				minValueType = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.minvalue.type");

				try {
					Class class1 = Class
							.forName("com.polaris.teamd.common.validations.CIntMinimumValueValidator");
					Object object = class1.newInstance();
					Method method = class1.getMethod("setMinimumDataValue",
							int.class);
					method.invoke(object, Integer.parseInt(minValue));
					cValidatingListener.addValidator((CValidator) object);
					cInputPanel.addValidators(cValidatingListener);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}

			if (validatorClass
					.equals("com.polaris.teamd.common.validations.CIntValueRangeValidator")) {
				maxValue = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.maxvalue");
				maxValueType = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.maxvalue.type");
				minValue = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.minvalue");
				minValueType = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.minvalue.type");

				try {
					Class class1 = Class
							.forName("com.polaris.teamd.common.validations.CIntValueRangeValidator");
					Object object = class1.newInstance();
					Method method = class1.getMethod("setMinValue", int.class);
					method.invoke(object, Integer.parseInt(minValue));

					method = class1.getMethod("setMaxValue", int.class);
					method.invoke(object, Integer.parseInt(maxValue));
					cValidatingListener.addValidator((CValidator) object);
					cInputPanel.addValidators(cValidatingListener);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}

			if (validatorClass
					.equals("com.polaris.teamd.common.validations.CStringLengthRangeValidator")) {
				maxLength = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.maxlength");
				maxLengthType = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.maxlength.type");
				minLength = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.minlength");
				minLengthType = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.minlength.type");

				try {
					Class class1 = Class
							.forName("com.polaris.teamd.common.validations.CStringLengthRangeValidator");
					Object object = class1.newInstance();
					Method method = class1.getMethod("setMinimumLength",
							int.class);
					method.invoke(object, Integer.parseInt(minLength));

					method = class1.getMethod("setMaximumLength", int.class);
					method.invoke(object, Integer.parseInt(maxLength));
					cValidatingListener.addValidator((CValidator) object);
					cInputPanel.addValidators(cValidatingListener);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}

			if (validatorClass
					.equals("com.polaris.teamd.common.validations.CStringMaxLengthValidator")) {
				maxLength = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.maxlength");
				System.out.println(maxLength);
				maxLengthType = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.maxlength.type");

				try {
					Class class1 = Class
							.forName("com.polaris.teamd.common.validations.CStringMaxLengthValidator");
					Object object = class1.newInstance();
					Method method = class1.getMethod("setMaximumLength",
							int.class);
					method.invoke(object, Integer.parseInt(maxLength));
					cValidatingListener.addValidator((CValidator) object);
					cInputPanel.addValidators(cValidatingListener);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}

			if (validatorClass
					.equals("com.polaris.teamd.common.validations.CStringMinLengthValidator")) {
				minLength = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.minlength");
				minLengthType = inputPanelProcessor
						.getStringProperty("form.inputpanel.0" + index
								+ ".validator.minlength.type");

				try {
					Class class1 = Class
							.forName("com.polaris.teamd.common.validations.CStringMinLengthValidator");
					Object object = class1.newInstance();
					Method method = class1.getMethod("setMinimumLength",
							int.class);
					method.invoke(object, Integer.parseInt(minLength));
					cValidatingListener.addValidator((CValidator) object);
					cInputPanel.addValidators(cValidatingListener);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			if (validatorClass
					.equals("com.polaris.teamd.common.validations.CStringAlphaOnlyValidator")) {

				try {
					Class class1 = Class
							.forName("com.polaris.teamd.common.validations.CStringAlphaOnlyValidator");
					Object object = class1.newInstance();
					cValidatingListener.addValidator((CValidator) object);
					cInputPanel.addValidators(cValidatingListener);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
			}

			if (validatorClass
					.equals("com.polaris.teamd.common.validations.CStringDigitsOnlyValidator")) {
				try {
					Class class1 = Class
							.forName("com.polaris.teamd.common.validations.CStringDigitsOnlyValidator");
					Object object = class1.newInstance();
					cValidatingListener.addValidator((CValidator) object);
					cInputPanel.addValidators(cValidatingListener);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
			}

			if (validatorClass
					.equals("com.polaris.teamd.common.validations.CEmailValidator")) {
				try {
					Class class1 = Class
							.forName("com.polaris.teamd.common.validations.CEmailValidator");
					Object object = class1.newInstance();
					cValidatingListener.addValidator((CValidator) object);
					cInputPanel.addValidators(cValidatingListener);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
			}
			index++;
		}

		return cInputPanel;
	}

	public CMultiCheckInputPanel setMultiCheckUI(String fileName,
			CMultiCheckInputPanel multiCheckInputPanel) {
		inputPanelProcessor = new PropertyFileProcessing();
		inputPanelProcessor.setPropertyFile(new File(fileName));
		int labelWidth = inputPanelProcessor
				.getIntProperty("form.inputpanel.label.width");
		int labelHeight = inputPanelProcessor
				.getIntProperty("form.inputpanel.label.height");

		int textWidth = inputPanelProcessor
				.getIntProperty("form.inputpanel.input.width");
		int textHeight = inputPanelProcessor
				.getIntProperty("form.inputpanel.input.height");
		String labelCaption = inputPanelProcessor
				.getStringProperty("form.inputpanel.caption");
		boolean isMandatory = inputPanelProcessor
				.getBooleanProperty("form.inputpanel.isMandatory");
		boolean isHidden = inputPanelProcessor
				.getBooleanProperty("form.inputpanel.hide");
		int orientation = inputPanelProcessor
				.getIntProperty("form.inputpanel.orientation");
		multiCheckInputPanel.setLabelWidth(labelWidth);
		multiCheckInputPanel.setLabelHeight(labelHeight);
		multiCheckInputPanel.setMultiChecktWidth(textWidth);
		multiCheckInputPanel.setMultiCheckHeight(textHeight);
		multiCheckInputPanel.cSetLabelString(labelCaption);
		multiCheckInputPanel.setMandatory(isMandatory);
		if (isHidden) {
			multiCheckInputPanel.cHide();
		}
		multiCheckInputPanel.cSetOrientation(orientation);
		return multiCheckInputPanel;

	}

	public CEditorOutputPanel setEditorPanelUI(String fileName,
			CEditorOutputPanel cEditorOutputPanel) {
		inputPanelProcessor = new PropertyFileProcessing();
		inputPanelProcessor.setPropertyFile(new File(fileName));
		int labelWidth = inputPanelProcessor
				.getIntProperty("form.inputpanel.label.width");
		int labelHeight = inputPanelProcessor
				.getIntProperty("form.inputpanel.label.height");
		int panelWidth = inputPanelProcessor
				.getIntProperty("form.inputpanel.panel.width");
		int panelHeight = inputPanelProcessor
				.getIntProperty("form.inputpanel.panel.height");

		String labelCaption = inputPanelProcessor
				.getStringProperty("form.inputpanel.label.caption");
		String buttonCaption = inputPanelProcessor
				.getStringProperty("form.inputpanel.button.caption");
		boolean isMandatory = inputPanelProcessor
				.getBooleanProperty("form.inputpanel.isMandatory");
		boolean isHidden = inputPanelProcessor
				.getBooleanProperty("form.inputpanel.hide");
		int orientation = inputPanelProcessor
				.getIntProperty("form.inputpanel.orientation");
		cEditorOutputPanel.setCaptionWidth(labelWidth);
		cEditorOutputPanel.setCaptionHeight(labelHeight);
		cEditorOutputPanel.setPanelWidth(panelWidth);
		cEditorOutputPanel.setPanelheight(panelHeight);
		cEditorOutputPanel.setActionButtonString(buttonCaption);
		cEditorOutputPanel.setCaptionString(labelCaption);
		if (isHidden) {
			cEditorOutputPanel.hide();
		}
		cEditorOutputPanel.setOrientation(orientation);
		return cEditorOutputPanel;

	}

	public CPasswordInputPanel setPasswordUI(String fileName,
			CPasswordInputPanel cPasswordInputPanel) {
		inputPanelProcessor = new PropertyFileProcessing();
		inputPanelProcessor.setPropertyFile(new File(fileName));
		int labelWidth = inputPanelProcessor
				.getIntProperty("form.inputpanel.label.width");
		int labelHeight = inputPanelProcessor
				.getIntProperty("form.inputpanel.label.height");

		int textWidth = inputPanelProcessor
				.getIntProperty("form.inputpanel.input.width");
		int textHeight = inputPanelProcessor
				.getIntProperty("form.inputpanel.input.height");
		String labelCaption = inputPanelProcessor
				.getStringProperty("form.inputpanel.caption");
		boolean isMandatory = inputPanelProcessor
				.getBooleanProperty("form.inputpanel.isMandatory");
		boolean isHidden = inputPanelProcessor
				.getBooleanProperty("form.inputpanel.hide");
		int orientation = inputPanelProcessor
				.getIntProperty("form.inputpanel.orientation");
		cPasswordInputPanel.cSetCaptionWidth(labelWidth);
		cPasswordInputPanel.cSetCaptionHeight(labelHeight);
		System.out.println(labelCaption);
		cPasswordInputPanel.cSetInputWidth(textWidth);
		cPasswordInputPanel.cSetInputHeight(textHeight);
		cPasswordInputPanel.cSetCaptionLabelString(labelCaption);
		cPasswordInputPanel.cSetMandatory(isMandatory);
		if (isHidden) {
			cPasswordInputPanel.hide();
		}
		cPasswordInputPanel.cSetOrientation(orientation);
		return cPasswordInputPanel;

	}

	public CDatePickerInputPanel setDatePickerUI(String fileName,
			CDatePickerInputPanel datePickerInputPanel) {
		inputPanelProcessor = new PropertyFileProcessing();
		inputPanelProcessor.setPropertyFile(new File(fileName));
		int datePickerType=inputPanelProcessor.getIntProperty("form.inputpanel.datepickertype");
		datePickerInputPanel.setDatePickerPreferences(datePickerType);
		datePickerInputPanel.init();
		return datePickerInputPanel;
	}

	public CRadioGroupInputPanel setRadioGroupUI(String fileName,
			CRadioGroupInputPanel radioGroupInputPanel) {
		inputPanelProcessor = new PropertyFileProcessing();
		inputPanelProcessor.setPropertyFile(new File(fileName));
		int labelWidth = inputPanelProcessor
				.getIntProperty("form.inputpanel.label.width");
		int labelHeight = inputPanelProcessor
				.getIntProperty("form.inputpanel.label.height");
		String labelCaption = inputPanelProcessor
				.getStringProperty("form.inputpanel.caption");
		boolean isMandatory = inputPanelProcessor
				.getBooleanProperty("form.inputpanel.isMandatory");
		boolean isHidden = inputPanelProcessor
				.getBooleanProperty("form.inputpanel.hide");
		int orientation = inputPanelProcessor
				.getIntProperty("form.inputpanel.orientation");
		radioGroupInputPanel.setLabelWidth(labelWidth);
		radioGroupInputPanel.setLabelHeight(labelHeight);

		radioGroupInputPanel.setCaptionString(labelCaption);
		radioGroupInputPanel.setMandatory(isMandatory);
		if (isHidden) {
			radioGroupInputPanel.hide();
		}
		radioGroupInputPanel.setOrientation(orientation);
		return radioGroupInputPanel;

	}

	public CSpinnerInputPanel setSpinnerUI(String fileName,
			CSpinnerInputPanel spinnerInputPanel) {
		inputPanelProcessor = new PropertyFileProcessing();
		inputPanelProcessor.setPropertyFile(new File(fileName));
		int labelWidth = inputPanelProcessor
				.getIntProperty("form.inputpanel.label.width");
		int labelHeight = inputPanelProcessor
				.getIntProperty("form.inputpanel.label.height");

		int spinnerWidth = inputPanelProcessor
				.getIntProperty("form.inputpanel.input.width");
		int spinnerHeight = inputPanelProcessor
				.getIntProperty("form.inputpanel.input.height");
		String labelCaption = inputPanelProcessor
				.getStringProperty("form.inputpanel.caption");
		boolean isMandatory = inputPanelProcessor
				.getBooleanProperty("form.inputpanel.isMandatory");
		boolean isHidden = inputPanelProcessor
				.getBooleanProperty("form.inputpanel.hide");
		int orientation = inputPanelProcessor
				.getIntProperty("form.inputpanel.orientation");
		spinnerInputPanel.cSetCaptionSize(labelWidth, labelHeight);
		spinnerInputPanel.cSetInputSize(spinnerWidth, spinnerHeight);
		spinnerInputPanel.setCaptionString(labelCaption);
		spinnerInputPanel.setMandatory(isMandatory);
		if (isHidden) {
			spinnerInputPanel.hide();
		}
		spinnerInputPanel.setOrientation(orientation);
		return spinnerInputPanel;

	}

	public CTextInputPanel setTextInputPanelUI(CTextInputPanel cTextInputPanel,
			String fileName) {
		System.out.println(fileName);
		inputPanelProcessor.setPropertyFile(new File(fileName));
		int labelWidth = inputPanelProcessor
				.getIntProperty("form.inputpanel.label.width");
		int labelHeight = inputPanelProcessor
				.getIntProperty("form.inputpanel.label.height");
		int errorWidth = inputPanelProcessor
				.getIntProperty("form.inputpanel.errormessage.width");
		int errorHeight = inputPanelProcessor
				.getIntProperty("form.inputpanel.errormessage.height");
		int textWidth = inputPanelProcessor
				.getIntProperty("form.inputpanel.input.width");
		int textHeight = inputPanelProcessor
				.getIntProperty("form.inputpanel.input.height");
		String labelCaption = inputPanelProcessor
				.getStringProperty("form.inputpanel.caption");
		boolean isMandatory = inputPanelProcessor
				.getBooleanProperty("form.inputpanel.isMandatory");
		boolean isHidden = inputPanelProcessor
				.getBooleanProperty("form.inputpanel.hide");
		int orientation = inputPanelProcessor
				.getIntProperty("form.inputpanel.orientation");
		cTextInputPanel.setLabelWidth(labelWidth);
		cTextInputPanel.setLabelHeight(labelHeight);
		cTextInputPanel.setErrorMessageWidth(errorWidth);
		cTextInputPanel.setErrorMessageheight(errorHeight);
		cTextInputPanel.setInputWidth(textWidth);
		cTextInputPanel.setInputHeight(textHeight);
		cTextInputPanel.setMandatory(isMandatory);
		cTextInputPanel.setCaptionString(labelCaption);
		cTextInputPanel.setOrientation(orientation);
		if (isHidden)
			cTextInputPanel.hide();
		else
			cTextInputPanel.show();
		return cTextInputPanel;
	}

	public CMultiTextInputPanel setMultiTextUI(String fileName,
			CMultiTextInputPanel multiTextInputPanel) {
		inputPanelProcessor = new PropertyFileProcessing();
		inputPanelProcessor.setPropertyFile(new File(fileName));
		int width = inputPanelProcessor
				.getIntProperty("form.inputpanel.label.width");
		multiTextInputPanel.setCaptionLabelWidth(width);
		int height = inputPanelProcessor
				.getIntProperty("form.inputpanel.label.height");
		multiTextInputPanel.setCaptionLabelHeight(height);
		int inputWidth = inputPanelProcessor
				.getIntProperty("form.inputpanel.input.width");
		multiTextInputPanel.setMultiTextWidth(inputWidth);
		int inputHeight = inputPanelProcessor
				.getIntProperty("form.inputpanel.input.height");
		multiTextInputPanel.setMultiTextHeight(inputWidth);
		int errorWidth = inputPanelProcessor
				.getIntProperty("form.inputpanel.errormessage.label.width");
		multiTextInputPanel.setErrorMessageWidth(errorWidth);
		int errorHeight = inputPanelProcessor
				.getIntProperty("form.inputpanel.errormessage.label.height");
		multiTextInputPanel.setErrorMessageHeight(errorHeight);
		String caption = inputPanelProcessor
				.getStringProperty("form.inputpanel.caption");
		multiTextInputPanel.setLabelString(caption);
		int orientation = inputPanelProcessor
				.getIntProperty("form.inputpanel.orientation");
		multiTextInputPanel.setOrientation(orientation);
		return multiTextInputPanel;

	}

	public CTextOutputPanel setTextOutputPanelUI(
			CTextOutputPanel cTextOutputPanel, String fileName) {
		inputPanelProcessor.setPropertyFile(new File(fileName));
		int labelWidth = inputPanelProcessor
				.getIntProperty("form.inputpanel.label.width");
		int labelHeight = inputPanelProcessor
				.getIntProperty("form.inputpanel.label.height");

		int outputLabelWidth = inputPanelProcessor
				.getIntProperty("form.inputpanel.input.width");
		int outputLabelHeight = inputPanelProcessor
				.getIntProperty("form.inputpanel.input.height");
		String labelCaption = inputPanelProcessor
				.getStringProperty("form.inputpanel.caption");
		String outputLabelCaption = inputPanelProcessor
				.getStringProperty(("form.inputpanel.outputCaption"));

		boolean isHidden = inputPanelProcessor
				.getBooleanProperty("form.inputpanel.hide");
		int orientation = inputPanelProcessor
				.getIntProperty("form.inputpanel.orientation");

		cTextOutputPanel.setLabelWidth(labelWidth);
		cTextOutputPanel.setLabelHeight(labelHeight);
		cTextOutputPanel.setOutputWidth(outputLabelWidth);
		cTextOutputPanel.setOutputHeight(outputLabelHeight);
		cTextOutputPanel.setCaptionString(labelCaption);
		cTextOutputPanel.setOutputString(outputLabelCaption);
		cTextOutputPanel.setOrientation(orientation);

		if (isHidden)
			cTextOutputPanel.hide();
		else
			cTextOutputPanel.show();
		return cTextOutputPanel;
	}

	public CSingleSelectInputTablePanel setTableUI(
			CSingleSelectInputTablePanel tablePanel, String fileName) {
		CSingleSelectInputTable table = tablePanel.cGetsingleSelectInputTable();
		PropertyFileProcessing processor = new PropertyFileProcessing();
		try {
			processor.setPropertyFile(new File("resources/ui/ui.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		String headFontName = processor
				.getStringProperty("ui.table.heading.font.name");
		int headFontSize = processor
				.getIntProperty("ui.table.heading.font.size");
		String fontStyle = processor
				.getStringProperty("ui.table.heading.font.style");

		int backgroundRed = processor
				.getIntProperty("ui.table.heading.backgroundColor.red");
		int backgroundGreen = processor
				.getIntProperty("ui.table.heading.backgroundColor.green");
		int backgroundBlue = processor
				.getIntProperty("ui.table.heading.backgroundColor.blue");

		int headRowHeight = processor
				.getIntProperty("ui.table.heading.row.height");
		int rowHeight = processor.getIntProperty("ui.table.row.height");
		int rowColorRed = processor.getIntProperty("ui.table.row.color.red");
		int rowColorGreen = processor.getIntProperty("ui.table.row.color.green");
		int rowColorBlue = processor.getIntProperty("ui.table.row.color.blue");
		String fontName = processor.getStringProperty("ui.table.font.name");
		int fontSize = processor.getIntProperty("ui.table.font.size");
		String fontStyle11 = processor.getStringProperty("ui.table.font.style");

		inputPanelProcessor = new PropertyFileProcessing();
		try {
			inputPanelProcessor.setPropertyFile(new File(fileName));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] colWidths = inputPanelProcessor
				.getIndexedPropertyValues("colWidth");
		int[] columnWidths = new int[colWidths.length];
		int i = 0;
		for (String colWidth : colWidths) {
			columnWidths[i] = Integer.parseInt(colWidths[i]);
		}
		TableColumnModel columnModel = table.getColumnModel();
		for (int j = 0; j < columnWidths.length; j++) {
			columnModel.getColumn(j).setWidth(columnWidths[i]);
		}
		int styleOfFont = -1;
		if (fontStyle11.equals("PLAIN"))
			styleOfFont = 0;
		if (fontStyle11.equals("BOLD"))
			styleOfFont = 1;
		if (fontStyle11.equals("ITALIC"))
			styleOfFont = 2;
		int styleOfHeadFont = -1;
		if (fontStyle.equals("PLAIN"))
			styleOfHeadFont = 0;
		if (fontStyle.equals("BOLD"))
			styleOfHeadFont = 1;
		if (fontStyle.equals("ITALIC"))
			styleOfHeadFont = 2;
		table.setRowHeight(rowHeight);
		JTableHeader header = table.getTableHeader();
		header.setPreferredSize(new Dimension(header.getWidth(), headRowHeight));
		header.setSize(header.getWidth(), headRowHeight);
		header.setFont(new Font(headFontName, styleOfHeadFont, headFontSize));
		header.setBackground(new Color(backgroundRed, backgroundGreen,
				backgroundBlue));
		table.setBackground(new Color(rowColorRed, rowColorGreen, rowColorBlue));
		table.setFont(new Font(fontName, styleOfFont, fontSize));
		return tablePanel;

	}

	public CActionPanel setActionPanelUI(CActionPanel actionPanel,
			String fileName) {
		String[] buttonHeightStrings = inputPanelProcessor
				.getIndexedPropertyValues("height");
		String[] buttonWidthStrings = inputPanelProcessor
				.getIndexedPropertyValues("width");
		String[] buttonCaptions = inputPanelProcessor
				.getIndexedPropertyValues("caption");
		// String[] buttonActions = inputPanelProcessor
		// .getIndexedPropertyValues("action");
		int[] buttonHeights = new int[buttonHeightStrings.length];
		for (int i = 0; i < buttonHeightStrings.length; i++)
			buttonHeights[i] = Integer.parseInt(buttonHeightStrings[i]);
		int[] buttonWidths = new int[buttonWidthStrings.length];
		for (int i = 0; i < buttonWidthStrings.length; i++)
			buttonWidths[i] = Integer.parseInt(buttonWidthStrings[i]);
		actionPanel.setButtonWidths(buttonWidths);
		actionPanel.setButtonHeights(buttonHeights);
		actionPanel.cAdd(buttonCaptions);
		// actionPanel.setActionStrings(buttonActions);
		return actionPanel;
	}

	public CComboInputPanel setComboUI(String fileName,
			CComboInputPanel comboInputPanel) {
		inputPanelProcessor = new PropertyFileProcessing();
		inputPanelProcessor.setPropertyFile(new File(fileName));
		int labelWidth = inputPanelProcessor
				.getIntProperty("form.inputpanel.label.width");
		int labelHeight = inputPanelProcessor
				.getIntProperty("form.inputpanel.label.height");

		int comboBoxWidth = inputPanelProcessor
				.getIntProperty("form.inputpanel.input.width");
		int comboBoxHeight = inputPanelProcessor
				.getIntProperty("form.inputpanel.input.height");
		String labelCaption = inputPanelProcessor
				.getStringProperty("form.inputpanel.caption");
		boolean isMandatory = inputPanelProcessor
				.getBooleanProperty("form.inputpanel.isMandatory");
		boolean isHidden = inputPanelProcessor
				.getBooleanProperty("form.inputpanel.hide");
		int orientation = inputPanelProcessor
				.getIntProperty("form.inputpanel.orientation");
		comboInputPanel.cSetCaptionSize(labelWidth, labelHeight);
		comboInputPanel.cSetInputSize(comboBoxWidth, comboBoxHeight);
		comboInputPanel.setCaptionString(labelCaption);
		comboInputPanel.setMandatory(isMandatory);
		if (isHidden) {
			comboInputPanel.hide();
		}
		comboInputPanel.setOrientation(orientation);
		return comboInputPanel;
	}
	
	public CEmptyPanel setEmptyPanelUI(CEmptyPanel cEmptyPanel, String fileName) {
		inputPanelProcessor.setPropertyFile(new File(fileName));
		int panelWidth = inputPanelProcessor
				.getIntProperty("form.inputpanel.width");
		int panelHeight = inputPanelProcessor
				.getIntProperty("form.inputpanel.height");
		cEmptyPanel.setHeight(panelHeight);
		cEmptyPanel.setWidth(panelWidth);
		return cEmptyPanel;
	}

	public CSingleSelectListInputPanel setListInputPanelUI(
			CSingleSelectListInputPanel cSingleSelectListInputPanel,
			String fileName) {
		inputPanelProcessor.setPropertyFile(new File(fileName));
		int labelWidth = inputPanelProcessor
				.getIntProperty("form.inputpanel.label.width");
		int labelHeight = inputPanelProcessor
				.getIntProperty("form.inputpanel.label.height");
		int errorWidth = inputPanelProcessor
				.getIntProperty("form.inputpanel.errormessage.width");
		int errorHeight = inputPanelProcessor
				.getIntProperty("form.inputpanel.errormessage.height");
		int inputWidth = inputPanelProcessor
				.getIntProperty("form.inputpanel.input.width");
		int inputHeight = inputPanelProcessor
				.getIntProperty("form.inputpanel.input.height");
		String captionLabelString = inputPanelProcessor
				.getStringProperty("form.inputpanel.caption");
		int listWidth = inputPanelProcessor
				.getIntProperty("form.inputpanel.list.Width");
		int listHeight = inputPanelProcessor
				.getIntProperty("form.inputpanel.list.height");
		boolean isMandatory = inputPanelProcessor
				.getBooleanProperty("form.inputpanel.isMandatory");
		boolean isHidden = inputPanelProcessor
				.getBooleanProperty("form.inputpanel.hide");
		int orientation = inputPanelProcessor
				.getIntProperty("form.inputpanel.orientation");
		cSingleSelectListInputPanel.setLabelWidth(labelWidth);
		cSingleSelectListInputPanel.setLabelHeight(labelHeight);
		cSingleSelectListInputPanel.setErrorMessageWidth(errorWidth);
		cSingleSelectListInputPanel.setErrorMessageheight(errorHeight);
		cSingleSelectListInputPanel.setLabelString(captionLabelString);
		cSingleSelectListInputPanel.setListHeight(listHeight);
		cSingleSelectListInputPanel.setListWidth(listWidth);
		cSingleSelectListInputPanel.setHideOnSelection(isMandatory);

		cSingleSelectListInputPanel.setOrientation(orientation);
		if (isHidden)
			cSingleSelectListInputPanel.hide();
		else
			cSingleSelectListInputPanel.show();
		return cSingleSelectListInputPanel;
	}

	public CEditorOutputPanel createCEditorOutputPanel() {
		CEditorOutputPanel cEditorOutputPanel = new CEditorOutputPanel();
		return cEditorOutputPanel;
	}

	public CPasswordInputPanel createPasswordPanel() {
		CPasswordInputPanel passwordInputPanel = new CPasswordInputPanel();
		return passwordInputPanel;
	}

	public CTextInputPanel createTextInputPanel() {

		CTextInputPanel cTextInputPanel = new CTextInputPanel();

		return cTextInputPanel;
	}

	public CTextOutputPanel createTextOutputPanel() {

		CTextOutputPanel cTextOutputPanel = new CTextOutputPanel();

		return cTextOutputPanel;
	}

	public CMultiTextInputPanel createMultiTextPanel() {
		CMultiTextInputPanel multiTextInputPanel = new CMultiTextInputPanel();
		return multiTextInputPanel;
	}

	public CSpinnerInputPanel createSpinnerPanel() {
		CSpinnerInputPanel spinnerInputPanel = new CSpinnerInputPanel();
		return spinnerInputPanel;
	}
	
	public CEmptyPanel createEmptyPanel() {
		return new CEmptyPanel();
	}

	public CComboInputPanel createComboPanel() {
		CComboInputPanel comboInputPanel = new CComboInputPanel();
		return comboInputPanel;
	}

	public CRadioGroupInputPanel createRadioGroupPanel() {
		CRadioGroupInputPanel radioGroupInputPanel = new CRadioGroupInputPanel();
		return radioGroupInputPanel;
	}

	@SuppressWarnings("unchecked")
	public CMultiCheckInputPanel createMultiCheckPanel() {
		CMultiCheckInputPanel multiCheckInputPanel = new CMultiCheckInputPanel();
		return multiCheckInputPanel;
	}

	public CDatePickerInputPanel createDatePickerInputPanel() {
		return new CDatePickerInputPanel();
	}

	public CSingleSelectListInputPanel createListInputPanel() {
		CSingleSelectListInputPanel cSingleSelectListInputPanel = new CSingleSelectListInputPanel();
		return cSingleSelectListInputPanel;

	}

	public CSingleSelectInputTablePanel createSingleSelectTablePanel() {
		CSingleSelectInputTablePanel inputTablePanel = new CSingleSelectInputTablePanel();
		return inputTablePanel;
	}

	public CActionPanel createActionPanel() {
		CActionPanel cActionPanel = (CActionPanel) createUIComponent(CUIComponentType.ACTIONPANEL);
		return cActionPanel;
	}

	public CWizard createWizard(String fileName) {
		CWizard wizard = (CWizard) createUIComponent(WIZARD);

		try {
			inputPanelProcessor.setPropertyFile(new File(fileName));
			String[] cFormsNames = inputPanelProcessor
					.getIndexedPropertyValues("panel");
			for (String cFormName : cFormsNames)
				wizard.cAdd(createForm(cFormName));
			CActionPanel actionPanel = createActionPanel();
		//	wizard.setActionPanel(actionPanel);
			int layoutType = inputPanelProcessor
					.getIntProperty("wizard.layouttype");
		//	wizard.setLayout(layoutType);
			// wizard=wizard.render();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return wizard;
	}

	public CFilterTableInputPanel createFilterTablePanel() {
		CFilterTableInputPanel cFilterTableInputPanel = new CFilterTableInputPanel();
		return cFilterTableInputPanel;
	}

}
