package steps

import ga.ContratoController

class ContratoTestDataAndOperations{

    public static createContrato (String contratante,String contratado,String data_ini,String data_term){

        def controller = new ContratoController()
        controller.params << [contratante: contratante,contratado:contratado,data_inicio:data_ini,
                              data_termino:data_term,valor:1200.00 ]

        controller.request.setContent(new byte[1000])
        controller.saveContrato(controller.criarContrato())
        controller.response.reset()
    }
   
    public static void createContrato(String contratante, String contratado, String data_Inicio, String data_Termino) {
		def cont = new ContratoController()
        cont.params << [contratante: contratante, contratado: contratado,
                data_Inicio: data_Inicio, data_Termino: data_termino, valor: 1200.00]
        cont.request.setContent(new byte[1000]) // Could also vary the request content.
        cont.create()
        cont.save()
        cont.response.reset()
	}

	public static void removeContrato(String contratante, String contratado, String data_Inicio, String data_Termino) {
        def testContrato = Contrato.findWHere(contratado: contratado, contratante: contratante data_Inicio: dateBegin, data_Termino: dateEnd)
        def cont = new PeriodicoController()
        cont.params << [contratado: testContrato.contratado, contratante: testContrato.contratante, data_Inicio: testContrato.dateBegin, data_Termino: testContrato.dateEnd]
        cont.delete()
    }
}

