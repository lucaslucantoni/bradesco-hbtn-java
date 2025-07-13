package Heranca.salario;

public class Gerente extends Empregado {

    public Gerente(double salarioFixo) {
        super(salarioFixo);
    }

    @Override
    public double calcularBonus(Departamento departamento) {

        if (departamento.alcancouMeta()){
            double bonusFixo = getSalarioFixo() * 0.20;
            double diffMeta =  (departamento.getValorAtingidoMeta() - departamento.getValorMeta()) * 0.01;
            
            return bonusFixo + diffMeta;
        }

        return 0;
    }
}
