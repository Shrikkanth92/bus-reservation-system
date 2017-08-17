/**
 * 
 */
package com.polaris.teamd.ui.custom;

import java.awt.Color;

/**
 * 
 * @author shrikkanth.ramesh
 *
 */
public class CWizardStep {

	private int stepId, status;
	private String description;
	private CLabel cLabel;

	public CWizardStep() {
		super();
	}

	public CWizardStep(int stepId, int status, String description, CLabel cLabel) {
		super();
		this.stepId = stepId;
		this.status = status;
		this.description = description;
		this.cLabel = cLabel;
		this.cLabel.setText(description);
	}

	public int getStepId() {
		return stepId;
	}

	public void setStepId(int stepId) {
		this.stepId = stepId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
		if (status == 0) {
			cLabel.setBackground(Color.GRAY);
			cLabel.setOpaque(true);
			cLabel.invalidate();
			cLabel.validate();
		}
		if (status == 1) {
			cLabel.setBackground(Color.ORANGE);
			cLabel.setOpaque(true);
			cLabel.invalidate();
			cLabel.validate();
		}
		if (status == 2) {
			cLabel.setBackground(Color.GREEN);
			cLabel.setOpaque(true);
			cLabel.invalidate();
			cLabel.validate();
		}
		cLabel.repaint();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CLabel getcLabel() {
		return cLabel;
	}

	public void setcLabel(CLabel cLabel) {
		this.cLabel = cLabel;
	}

}
