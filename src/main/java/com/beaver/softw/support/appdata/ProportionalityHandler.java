package com.beaver.softw.support.appdata;

import java.awt.Dimension;

import lombok.Setter;

final class ProportionalityHandler {
	@Setter
	private Dimension proportionalityFactor;

	public ProportionalityHandler(Dimension proportionalityFactor) {
		this.proportionalityFactor = proportionalityFactor;
	}

	public int calculate(final int percentage, final char base) {
		return base == 'w' ?
			this.proportionalityFactor.width*percentage/100 :
			this.proportionalityFactor.height*percentage/100;
	}

	public int calculate(final int percentage) {
		return this.calculate(percentage, 'w');
	}
}
