package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {

		double baseCalc = 1039.00;
		double salarioLiquido;
		double salarioBaseIrrf;
		double valorInss;
		double valorIrrf;

		if (salarioBase <= baseCalc) {
			salarioLiquido = 0.0;

			return Math.round(salarioLiquido);
		}

		valorInss = calcularInss(salarioBase);
		salarioBaseIrrf = salarioBase - valorInss;
		valorIrrf = calcularIrrf(salarioBaseIrrf);

		salarioLiquido = salarioBase - valorInss - valorIrrf;

		return Math.round(salarioLiquido);
	}

	private double calcularInss(double salarioBase) {

		double descontoInss = 0.00;

		double inssFaixa1 = 0.08;
		double inssFaixa2 = 0.09;
		double inssFaixa3 = 0.11;

		if (salarioBase <= 1500) {
			descontoInss = salarioBase * inssFaixa1;
		}
		if ((salarioBase > 1500) && (salarioBase <= 4000)) {
			descontoInss = salarioBase * inssFaixa2;
		}
		if (salarioBase > 4000) {
			descontoInss = salarioBase * inssFaixa3;
		}

		return descontoInss;
	}

	private double calcularIrrf(double salarioComDesconto) {

		double descontoIrrf = 0.00;

		double irrfFaixa1 = 0.00;
		double irrfFaixa2 = 0.075;
		double irrfFaixa3 = 0.15;

		if (salarioComDesconto <= 3000) {
			descontoIrrf = irrfFaixa1;
		}
		if ((salarioComDesconto > 3000) && (salarioComDesconto <= 6000)) {
			descontoIrrf = salarioComDesconto * irrfFaixa2;
		}
		if (salarioComDesconto > 6000) {
			descontoIrrf = salarioComDesconto * irrfFaixa3;
		}

		return descontoIrrf;
	}
}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/