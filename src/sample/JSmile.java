package sample;

import smile.Network;

public class JSmile {

    public Network net;

    public JSmile() {
        new smile.License(
                "SMILE LICENSE 2176bff4 7c12480b c466a518 " +
                        "THIS IS AN ACADEMIC LICENSE AND CAN BE USED " +
                        "SOLELY FOR ACADEMIC RESEARCH AND TEACHING, " +
                        "AS DEFINED IN THE BAYESFUSION ACADEMIC " +
                        "SOFTWARE LICENSING AGREEMENT. " +
                        "Serial #: ad28gb4ek8rjb9iwp8q85gx28 " +
                        "Issued for: Rafael Ribeiro (rafaelsyprianoribeiro@hotmail.com) " +
                        "Academic institution: UNISUL " +
                        "Valid until: 2020-11-29 " +
                        "Issued by BayesFusion activation server",
                new byte[]{
                        -56, -5, 108, 105, 75, -24, -7, 9, 18, -10, -45, -83, 73, 88, -85, 92,
                        -63, 86, 75, 121, -4, -41, -44, -111, -66, 94, -26, 43, -7, -115, -18, -61,
                        -53, 23, 125, 77, 20, 29, -80, 6, 125, -44, 67, 61, 35, 70, 2, 17,
                        91, -94, -2, 64, 69, -37, -32, -99, 12, 121, -19, 34, 79, 75, -39, -34
                }
        );
        net = new Network();
        net.readFile("TrabalhoFinalCancer.xdsl");
    }

    public String run(String evidencia, String valor) {
        if (valor.equals("Nenhum"))
            net.clearEvidence(evidencia);
        else
            net.setEvidence(evidencia, valor);
        net.updateBeliefs();

        String msg = "";
        System.out.println(net.getNodeName("doenca"));
        double[] beliefs = net.getNodeValue("doenca");
        for (int i = 0; i < beliefs.length; i++) {
            msg += net.getOutcomeId("doenca", i) + " = " + Math.round(beliefs[i] * 100) + "%\n";
        }
        System.out.println(msg);
        return msg;
    }
}
