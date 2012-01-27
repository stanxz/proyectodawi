package servicios;

import dao.CertificadoDAO;
import dao.CitaDAO;
import dao.DAOFactory;
import entidades.Certificadoa;

public class CertificadoasDaoService implements CertificadoasService {
	
	private DAOFactory fabrica = null;
	private CertificadoDAO certificadodao;
	
	public CertificadoasDaoService(int whichFactory) {
		
		fabrica = DAOFactory.getDAOFactory(whichFactory);
		this.certificadodao = fabrica.getCertificadoDAO();
		
	}

	@Override
	public void insertarCertificado(Certificadoa certificado) throws Exception {
		// TODO Auto-generated method stub
		this.certificadodao.insertarCertificado(certificado);
	}
	

}
