package model;

	public enum EstadosEnum{
		RO("Rondonia", 11), 
		AC("Acre", 12),
		AM("Amazonas", 13),
		RR("Roraima", 14),
		PA("Par�", 15),
		AP("Amap�", 16),
		TO("Tocantins", 17),
		MA("Maranh�o", 21),
		PI("Piau�", 22),
		CE("Cear�",  23),
		RN("Rio Grande do Norte", 24),
		PB("Para�ba", 25),
		PE("Pernambuco", 26),
		AL("Alagoas", 27),
		SE("Sergipe", 28),
		BA("Bahia", 29),
		MG("Minas Gerais", 31),
		ES("Esp�rito Santo", 32),
		RJ("Rio de Janeiro", 33),
		SP("S�o Paulo", 35),
		PR("Paran�", 41),
		SC("Santa Catarina", 42),
		RS("Rio Grande do Sul", 43),
		MS("Mato Grosso do Sul", 50),
		MT("Mato Grosso", 51),
		GO("Goi�s", 52),
		DF("Distrito Federal", 53),
		UF("UF N�o Idendificada",99);	
		
		private String nomeEstado;
		private int numEstado;

		EstadosEnum(String nomeEstado, int numEstado) {
			this.nomeEstado = nomeEstado;
			this.numEstado = numEstado;
		}
		
		public String getNomeEstado(){
			return nomeEstado;
		}
		
		public int numEstado(){
			return numEstado;
		}
		
		@Override
		public String toString(){
			return nomeEstado;
		}
		
		public static String getEstadoByNum(int codEstado)
		{
			for(EstadosEnum e : EstadosEnum.values()){
				if(codEstado == e.numEstado)
					return e.getNomeEstado();
			}
			return EstadosEnum.UF.getNomeEstado();
		}
	}
