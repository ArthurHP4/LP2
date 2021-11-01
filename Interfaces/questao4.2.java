Classe Abstrata: Abastecer 
 o progama deve facilitar o pagamento do abastacimento via cartão, dinheiro, ou pix.
 Justificativa: Facilitar as divergencias de cada forma de pagamento.

Class Abastecer{
	 public static void main (String[] args) {
		var abastecer = new Abastecer();
	 }

	public abstract class Pagamento {
		public precoCombus(precoCombus);
		public tamanhoTanque(tamanhoTanque);
		public formaPagamento(formaPagamento);
		public void Pagar (precoCombus * tamanhoTanque);

	}


	public class Pix extends Pagamento {
			  public void Pagar (precoCombus * tamanhoTanque);
			  {
					 ...
			   }
	}

	public class Cartao extends Pagamento {
			  public void Pagar (precoCombus * tamanhoTanque);
			  {
					....
			   }
	}

	public class Dinheiro extends Pagamento {
			  public void Pagar (precoCombus * tamanhoTanque);
			  {
				   ....
			   }
	}
}


Interface: Testar / Programa para auxilar pessoas da area de testes.
Justificativa: Auxiliar os desenvolvedores nos releases e encontrar erros ou bugs.


public interface ITeste {
       public boolean verificar(){
             ...
             }
       public boolean update(){
             ...
             }
       public boolean findError(){
             ...
             }
       public boolean save(){
             ...
             }


Exemplos das classes que a implementam:

Classe para achar bugs, atualizar codigo fonte, analizar dados; 


