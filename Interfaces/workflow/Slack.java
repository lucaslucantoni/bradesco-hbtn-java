package Interfaces.workflow;

public class Slack implements CanalNotificacao{

    @Override
    public void notificar(Mensagem mensagem) {
        System.out.printf("[SLACK] {%s} - %s\n",mensagem.getTipoMensagem().name(), mensagem.getTexto());
    }
    
}
