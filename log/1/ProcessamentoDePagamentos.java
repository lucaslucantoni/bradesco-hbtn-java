import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;


public class ProcessamentoDePagamentos {


    // Logger SLF4j
    private static final Logger logger = LoggerFactory.getLogger(ProcessamentoDePagamentos.class);


    public static void main(String[] args) throws InterruptedException {
        logger.info("Iniciando o processamento do pagamento 1");
        Thread.sleep(1000);
        logger.error("Erro ao processar o pagamento 1: Falha na transação.");
        logger.info("Iniciando o processamento do pagamento 2");
        Thread.sleep(1000);
        logger.info("Pagamento 2 processado com sucesso.");
        logger.info("Iniciando o processamento do pagamento 3");
        Thread.sleep(1000);
        logger.info("Pagamento 3 processado com sucesso.");
        logger.info("Iniciando o processamento do pagamento 4");
        Thread.sleep(1000);
        logger.error("Erro ao processar o pagamento 4: Falha na transação.");
        logger.info("Iniciando o processamento do pagamento 5");
        Thread.sleep(1000);
        logger.warn("Pagamento 5 está pendente. Aguardando confirmação.");
        logger.info("Processamento de pagamentos concluído.");
    }
}