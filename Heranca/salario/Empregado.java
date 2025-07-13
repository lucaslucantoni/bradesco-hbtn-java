package Heranca.salario;

public class Empregado {
    
    private double salarioFixo;

    public Empregado(double salarioFixo) {
        this.salarioFixo = salarioFixo;
    }

    public double getSalarioFixo() {
        return salarioFixo;
    }

    public void setSalarioFixo(double salarioFixo) {
        this.salarioFixo = salarioFixo;
    }

    public double calcularBonus(Departamento departamento){
        if (departamento.alcancouMeta()){
            return salarioFixo * 0.10;
        }
        return 0;
    }

    public double calcularSalarioTotal(Departamento departamento) {

        double bonus = calcularBonus(departamento);
        return salarioFixo + bonus;
    }

}
