package servicos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author lucas
 */
public class GeraCasas {

    private HashMap<String, ArrayList<String>> conjuntoMunicipioEstado;
    private Random gerador = new Random();

    /**
     * Construtor da classe
     */
    public GeraCasas() {
        //Inicializando o HashMap
        conjuntoMunicipioEstado = new HashMap<>();

        //O HashMap é preenchido da seguinte forma:
        //KEY: (String) Nome Do Estado 
        //VALUE:  (ArrayList<String>) Lista com 10 cidades
        conjuntoMunicipioEstado.put("Acre",
                new ArrayList<>(Arrays.asList("Rio Branco", "Cruzeiro do Sul", "Sena Madureira", "Tarauacá", "Feijó",
                                "Brasiléia", "Plácido de Castro", "Senador Guiomard", "Xapuri", "Marechal Thaumaturgo")));
        conjuntoMunicipioEstado.put("Alagoas",
                new ArrayList<>(Arrays.asList("Maceió", "Arapiraca", "Rio Largo", "Palmeira dos Índios", "Uniãos dos Palmares",
                                "Penedo", "São Miguel dos Campos", "Coruripe", "Delmiro Gouveia", "Maragogi")));
        conjuntoMunicipioEstado.put("Amapá",
                new ArrayList<>(Arrays.asList("Macapá", "Santana", "Laranjal do Jari", "Oiapoque", "Porto Grande",
                                "Mazagão", "Tartarugalzinho", "Pedra Branca do Amapari", "Serra do Navio", "Amapá")));
        conjuntoMunicipioEstado.put("Amazonas", 
                new ArrayList<>(Arrays.asList("Manaus", "Parintins", "Itacoatiara",
                                "Manacapuru", "Coari", "Tabatinga", "Maués", "Tefé", "Iranduba", "Benjamin Constant")));
        conjuntoMunicipioEstado.put("Bahia",
                new ArrayList<>(Arrays.asList("Salvador", "Feira de Santana", "Vitória da Conquista", "Camaçari",
                                "Itabuna", "Juazeiro", "Lauro de Freitas", "Ilhéus", "Jequié", "Teixeira de Freitas")));
        conjuntoMunicipioEstado.put("Ceará", 
                new ArrayList<>(Arrays.asList("Fortaleza", "Caucaia", "Juazeiro do Norte",
                                "Maracanaú", "Sobral", "Crato", "Itapipoca", "Maranguape", "Iguatu", "Quixadá")));
        conjuntoMunicipioEstado.put("Distrito Federal",
                new ArrayList<>(Arrays.asList("Brasília", "Ceilândia", "Taguatinga", "Samambaia", "Cruzeiro",
                                "Planaltina", "Recanto das Emas", "Gama", "Santa Maria", "São Sebastião")));
        conjuntoMunicipioEstado.put("Espírito Santo",  
                new ArrayList<>(Arrays.asList("Vitória", "Vila Velha", "Serra",
                                "Cariacica", "Cachoeiro de Itapemirim", "Linhares", "São Mateus", "Colatina", "Guarapari", "Aracruz")));
        conjuntoMunicipioEstado.put("Goiás",
                new ArrayList<>(Arrays.asList("Goiânia", "Aparecida de Goiânia", "Anápolis", "Rio Verde", "Luziânia",
                                "Águas Lindas de Goiás", "Valparaíso de Goiás", "Trindade", "Formosa", "Novo Gama")));
        conjuntoMunicipioEstado.put("Maranhão", 
                new ArrayList<>(Arrays.asList("São Luís", "Imperatriz", "Timon",
                                "Caxias", "Codó", "Paço do Lumiar", "Açailândia", "Bacabal", "Balsas", "Santa Inês")));
        conjuntoMunicipioEstado.put("Mato Grosso",
                new ArrayList<>(Arrays.asList("Cuiabá", "Várzea Grande", "Rondonópolis", "Sinop", "Tangará da Serra",
                                "Cáceres", "Sorriso", "Lucas do Rio Verde", "Primavera do Leste", "Barra do Garças")));
        conjuntoMunicipioEstado.put("Mato Grosso do Sul",
                new ArrayList<>(Arrays.asList("Campo Grande", "Dourados", "Três Lagoas", "Corumbá", "Ponta Porã",
                                "Naviraí", "Nova Andradina", "Aquidauana", "Sidrolândia", "Paranaíba")));
        conjuntoMunicipioEstado.put("Minas Gerais",
                new ArrayList<>(Arrays.asList("Belo Horizonte", "Uberlândia", "Contagem", "Juiz de Fora", "Belo Horizonte",
                                "Montes Claros", "Ribeirão das Neves", "Uberaba", "Governador Valadares", "Ipatinga")));
        conjuntoMunicipioEstado.put("Pará", 
                new ArrayList<>(Arrays.asList("Belém", "Ananindeua", "Santarém", "Marabá",
                                "Parauapebas", "Castanhal", "Itaituba", "Cametá", "Bragança", "Abaetetuba")));
        conjuntoMunicipioEstado.put("Paraíba", 
                new ArrayList<>(Arrays.asList("João Pessoa", "Campina Grande",
                                "Santa Rita", "Patos", "Bayeux", "Sousa", "Cajazeiras", "Cabedelo", "Guarabira", "Sapé")));
        conjuntoMunicipioEstado.put("Paraná",
                new ArrayList<>(Arrays.asList("Curitiba", "Londrina", "Maringá", "Pontal do Paraná", "Ponta Grossa",
                                "Cascavel", "São José dos Pinhais", "Foz do Iguaçu", "Colombo", "Guarapuava")));
        conjuntoMunicipioEstado.put("Pernambuco",
                new ArrayList<>(Arrays.asList("Recife", "Jaboatão dos Guararapes", "Olinda", "Caruaru", "Petrolina",
                                "Paulista", "Cabo de Santo Agostinho", "Camaragibe", "Garanhuns", "Vitória de Santo Antão")));
        conjuntoMunicipioEstado.put("Piauí", 
                new ArrayList<>(Arrays.asList("Teresina", "Parnaíba", "Picos", "Piripiri",
                                "Floriano", "José de Freitas", "Campo Maior", "Altos", "Barras", "União")));
        conjuntoMunicipioEstado.put("Rio de Janeiro",
                new ArrayList<>(Arrays.asList("Rio de Janeiro", "São Gonçalo", "Duque de Caxias", "Nova Iguaçu",
                                "Niterói", "Belford Roxo", "São João de Meriti", "Campos dos Goytacazes", "Petrópolis",
                                "Volta Redonda")));
        conjuntoMunicipioEstado.put("Rio Grande do Norte",
                new ArrayList<>(Arrays.asList("Natal", "Mossoró", "Parnamirim", "São Gonçalo do Amarante", "Macaíba",
                                "Ceará-Mirim", "Caicó", "Assu", "Currais Novos", "Santa Cruz")));
        conjuntoMunicipioEstado.put("Rio Grande do Sul",
                new ArrayList<>(Arrays.asList("Porto Alegre", "Caxias do Sul", "Pelotas", "Canoas", "Santa Maria",
                                "Gravataí", "Viamão", "Novo Hamburgo", "São Leopoldo", "Rio Grande")));
        conjuntoMunicipioEstado.put("Rondônia",
                new ArrayList<>(Arrays.asList("Porto Velho", "Ji-Paraná", "Ariquemes", "Vilhena", "Cacoal", "Jaru",
                                "Rolim de Moura", "Guajará-Mirim", "Machadinho d'Oeste", "Pimenta Bueno")));
        conjuntoMunicipioEstado.put("Roraima", 
                new ArrayList<>(Arrays.asList("Boa Vista", "Caracaraí", "Rorainópolis",
                                "Pacaraima", "São João da Baliza", "Bonfim", "São Luiz", "Caroebe", "Mucajaí", "Alto Alegre")));
        conjuntoMunicipioEstado.put("Santa Catarina", 
                new ArrayList<>(Arrays.asList("Florianópolis", "Joinville",
                                "Blumenau", "São José", "Criciúma", "Chapecó", "Itajaí", "Jaraguá do Sul", "Palhoça", "Lages")));
        conjuntoMunicipioEstado.put("São Paulo",
                new ArrayList<>(Arrays.asList("São Paulo", "Guarulhos", "Campinas", "São Bernardo do Campo", "Osasco",
                                "Santo André", "São José dos Campos", "Santos", "Ribeirão Preto", "Sorocaba")));
        conjuntoMunicipioEstado.put("Sergipe",
                new ArrayList<>(Arrays.asList("Aracaju", "Nossa Senhora do Socorro", "Lagarto", "Itabaiana",
                                "São Cristóvão", "Estância", "Tobias Barreto", "Itabaianinha", "Simão Dias",
                                "Nossa Senhora da Glória")));
        conjuntoMunicipioEstado.put("Tocantins",
                new ArrayList<>(Arrays.asList("Palmas", "Araguaína", "Gurupi", "Porto Nacional", "Paraíso do Tocantins",
                                "Guaraí", "Colinas do Tocantins", "Formoso do Araguaia", "Araguatins", "Tocantinópolis")));
    }

    /**
     * 
     * @return
     */
    public ArrayList<Imovel> geraArquivo() {
        int numeroAnuncio = 0;

        //Gerando 30 descrições aleatórias diferentes para uma Casa
        ArrayList<String> descricoesCasa = new ArrayList<>();
        descricoesCasa.addAll(Arrays.asList(
                "Encantadora casa com jardim exuberante e ambiente tranquilo.",
                "Espaçosa casa de família com quartos amplos e áreas de convivência aconchegantes.",
                "Casa contemporânea com design moderno e acabamentos de alta qualidade.",
                "Aconchegante casa térrea com varanda e quintal arborizado.",
                "Casa de praia com vista panorâmica do oceano e acesso direto à praia.",
                "Casa histórica restaurada, com detalhes originais preservados.",
                "Elegante casa de luxo com piscina, spa e áreas de entretenimento.",
                "Casa charmosa em um bairro tranquilo e arborizado.",
                "Casa de campo com lareira e ambientes aconchegantes para relaxar.",
                "Casa em condomínio fechado com segurança 24 horas e área de lazer.",
                "Casa moderna com conceito aberto e integração perfeita entre os ambientes.",
                "Casa sustentável com tecnologia de energia solar e sistemas eco-friendly.",
                "Casa geminada com terraço privativo e vista panorâmica da cidade.",
                "Casa de campo com pomar, horta e espaço para atividades ao ar livre.",
                "Casa com estilo arquitetônico único e características personalizadas.",
                "Casa colonial com varandas amplas e detalhes arquitetônicos encantadores.",
                "Casa contemporânea com espaços de estar elegantes e abundância de luz natural.",
                "Casa com piscina privativa e área de churrasco para momentos de lazer.",
                "Casa de praia com deck, jacuzzi e acesso privativo à praia.",
                "Casa de campo com vista para as montanhas e trilhas próximas para caminhadas.",
                "Casa com home office espaçoso e ambientes para trabalho e estudo.",
                "Casa de luxo com academia, sala de cinema e adega privativa.",
                "Casa em estilo rústico com elementos de madeira e pedra.",
                "Casa contemporânea com jardim vertical e terraço verde.",
                "Casa com vista para um lago ou rio, proporcionando uma atmosfera tranquila.",
                "Casa com espaços de entretenimento, como sala de jogos e bar.",
                "Casa em condomínio com campo de golfe e outras comodidades exclusivas.",
                "Casa com espaços para atividades ao ar livre, como quadra esportiva e piscina.",
                "Casa de campo com estilo provençal, mobiliário vintage e jardins românticos.",
                "Casa com arquitetura futurista e tecnologia de automação residencial."));

        //Gerando 30 descrições aleatórias diferentes para um nome de condomînio
        ArrayList<String> nomesDoCondominio = new ArrayList<>();
        nomesDoCondominio.addAll(Arrays.asList(
                "Residencial Primavera",
                "Condomínio Jardins do Sol",
                "Vista Verde Residence",
                "Parque das Águas",
                "Condomínio Vila Serena",
                "Solaris Residence Club",
                "Condomínio Alameda dos Pinheiros",
                "Bosque das Palmeiras",
                "Villa das Flores",
                "Condomínio Reserva do Lago",
                "Morada dos Sonhos",
                "Vale Verde Condominium",
                "Condomínio Terra Nova",
                "Alphaville Residence",
                "Condomínio dos Pássaros",
                "Jardim das Acácias",
                "Parque dos Ipês",
                "Condomínio Recanto Feliz",
                "Residencial Viver Bem",
                "Condomínio Harmonia",
                "Villa Bella Residence",
                "Condomínio Recanto das Montanhas",
                "Residencial das Palmeiras",
                "Jardim dos Girassóis",
                "Condomínio Bosque Encantado",
                "Vale dos Ventos",
                "Residencial dos Lagos",
                "Condomínio Vila Real",
                "Villa do Sol",
                "Residencial Vista Alegre"));

        //Gerando 30 descrições aleatórias diferentes para uma Apartamento
        ArrayList<String> descricoesApartamento = new ArrayList<>();
        descricoesApartamento.addAll(Arrays.asList(
                "Moderno apartamento com design contemporâneo e acabamentos de alta qualidade.",
                "Aconchegante apartamento com vista panorâmica da cidade e ambiente tranquilo.",
                "Espaçoso apartamento com quartos amplos e áreas de convivência confortáveis.",
                "Charmoso apartamento térreo com jardim privativo e espaço para atividades ao ar livre.",
                "Apartamento de luxo com terraço espaçoso e vista deslumbrante.",
                "Apartamento em condomínio fechado com segurança 24 horas e diversas comodidades.",
                "Apartamento com conceito aberto e integração perfeita entre sala de estar, jantar e cozinha.",
                "Apartamento com varanda gourmet e área de churrasco para momentos de lazer.",
                "Apartamento com academia, piscina e área de lazer para desfrutar de momentos de descontração.",
                "Apartamento com suíte master, closet e banheira de hidromassagem.",
                "Apartamento com home office privativo e ambientes adequados para trabalho e estudo.",
                "Apartamento com sistema de automação residencial e tecnologia avançada.",
                "Apartamento com área de serviço separada e espaços otimizados para organização.",
                "Apartamento com vista para o mar e acesso direto à praia.",
                "Apartamento com piso em madeira nobre e acabamentos de alto padrão.",
                "Apartamento com espaço gourmet equipado e cozinha moderna.",
                "Apartamento com suítes espaçosas e banheiros com acabamentos de luxo.",
                "Apartamento com sala de cinema privativa e sistema de som integrado.",
                "Apartamento com terraço privativo e jacuzzi para momentos de relaxamento.",
                "Apartamento com espaço para escritório e ambientes funcionais para produtividade.",
                "Apartamento com área de lazer completa, incluindo piscina, academia e salão de festas.",
                "Apartamento com sistema de segurança avançado e monitoramento 24 horas.",
                "Apartamento com varanda ampla e vista panorâmica da cidade.",
                "Apartamento com acesso a parques e áreas verdes próximas para atividades ao ar livre.",
                "Apartamento com localização privilegiada, próximo a comércios, escolas e serviços.",
                "Apartamento com ambientes integrados e decoração contemporânea.",
                "Apartamento com móveis planejados e aproveitamento inteligente de espaços.",
                "Apartamento com suíte master e closet espaçoso.",
                "Apartamento com área de serviço individual e banheiro de serviço.",
                "Apartamento com fácil acesso a transporte público e vias principais da cidade."));

        // String descricaoQuintal, String nomeDoCondominio, int numeroDoAnuncio, String
        // descricao, double valor, String cidade, String estado, int vagasGaragem,
        // double area
        // int numeroDoAnuncio, String descricao, double valor, String cidade, String
        // estado, int vagasGaragem, double area
        
        //Iniciando processo de gravação na List de retorno

        ArrayList<Imovel> retorno = new ArrayList<>();

        for (String temp_string : conjuntoMunicipioEstado.keySet()) {
            for (int k = 0; k < 12; k++) {
                                        //Repete (quantidade de cidades) vezes
                for (int i = 0; i < conjuntoMunicipioEstado.get(temp_string).size(); i++) {
                        retorno.add(new Casa("", nomesDoCondominio.get(gerador.nextInt(nomesDoCondominio.size())),
                                    numeroAnuncio, descricoesCasa.get(gerador.nextInt(descricoesCasa.size())),
                                    (gerador.nextInt(500000,2500000)),
                                    conjuntoMunicipioEstado.get(temp_string).get(gerador.nextInt(conjuntoMunicipioEstado.get(temp_string).size())),
                                    temp_string, (gerador.nextInt(4) + 1), (gerador.nextInt(400) + 10.0)));
                        numeroAnuncio++; //Incrementa a identificação para o próximo imóvel
                        }
            }
        }
        for (String temp_string : conjuntoMunicipioEstado.keySet()) {   //Percorre os 26 estados
            for (int k = 0; k < 12; k++) {
                for (int i = 0; i < conjuntoMunicipioEstado.get(temp_string).size(); i++) {
                    retorno.add(new Apartamento(gerador.nextInt(20), gerador.nextBoolean(), numeroAnuncio,
                            descricoesApartamento.get(gerador.nextInt(descricoesApartamento.size())),
                            (100000 + gerador.nextInt(1000000000)),
                            conjuntoMunicipioEstado.get(temp_string)
                                    .get(gerador.nextInt(conjuntoMunicipioEstado.get(temp_string).size())),
                            temp_string, (gerador.nextInt(4) + 1), (gerador.nextInt(400) + 10.0)));

                }
            }

        }

        return retorno;
    }

    public HashMap<String, ArrayList<String>> getConjuntoMunicipioEstado() {
        return conjuntoMunicipioEstado;
    }

    public void setConjuntoMunicipioEstado(HashMap<String, ArrayList<String>> conjuntoMunicipioEstado) {
        this.conjuntoMunicipioEstado = conjuntoMunicipioEstado;
    }

}
