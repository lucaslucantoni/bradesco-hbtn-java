import exceptions.OperacaoInvalidaException;

public class ContaBancariaBasica {
    private String numeracao;
    private double saldo;
    private double taxaJurosAnual;

    public ContaBancariaBasica(String numeracao, double taxaJurosAnual) {
        this.numeracao = numeracao;
        this.saldo = 0D;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public String getNumeracao() {
        return numeracao;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public void depositar(double valor) throws OperacaoInvalidaException {
        if (valor <= 0D)
            throw new OperacaoInvalidaException("Valor para deposito deve ser maior que 0");
        this.saldo += valor;
    }

    public void sacar(double valor) throws OperacaoInvalidaException {
        if (valor <= 0D)
            throw new OperacaoInvalidaException("Valor de saque deve ser maior que 0");
        if (this.saldo < valor)
            throw new OperacaoInvalidaException("Valor de saque deve ser menor que o saldo atual");
        this.saldo -= valor;
    }

    public double calcularTarifaMensal() {
        return Math.min(10D, this.saldo * 0.1);
    }

    public double calcularJurosMensal() {
        return this.saldo < 0D ? 0D : ((this.saldo * (this.taxaJurosAnual / 100D)) / 12D);
    }

    public void aplicarAtualizacaoMensal() {
        double tarifaMensal = calcularTarifaMensal();
        double jurosMensal = calcularJurosMensal();
        this.saldo -= tarifaMensal;
        this.saldo += jurosMensal;
    }
}