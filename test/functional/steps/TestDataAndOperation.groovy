package steps

class TestDataAndOperations {

	static public void createContrato(String contratante, String contratado, String data_Inicio, String data_Termino, String val) {
		def cont = new ContratoController()
        cont.params << [contratante: contratante, contratado: contratado,
                data_Inicio: data_Inicio, data_Termino: data_termino, valor: val]
        cont.request.setContent(new byte[1000]) // Could also vary the request content.
        cont.create()
        cont.save()
        cont.response.reset()
	}

	 static public void removeContrato(String contratante, String contratado, String data_Inicio, String data_Termino, String val) {
        def testContrato = Contrato.findWHere(contratado: name, contratado: contratado data_Inicio: dateBegin, data_Termino: dateEnd, valor: val)
        def cont = new PeriodicoController()
        cont.params << [contratado: testContrato.name, contratado: testContrato.contratado data_Inicio: testContrato.dateBegin, data_Termino: testContrato.dateEnd, valor: val]
        cont.delete()
    }