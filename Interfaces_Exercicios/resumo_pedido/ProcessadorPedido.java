import provedores.ProvedorFrete;

public class ProcessadorPedido {
    private ProvedorFrete provedorFrete;

    public ProcessadorPedido(ProvedorFrete provedorFrete) {
        this.provedorFrete = provedorFrete;
    }

    public void processar(Pedido0 pedido0) {
        pedido0.setFrete(provedorFrete.calcularFrete(pedido0.getPeso(), pedido0.getTotal()));
    }
}