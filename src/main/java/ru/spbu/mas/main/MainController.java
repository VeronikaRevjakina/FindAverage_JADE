package ru.spbu.mas.main;

import jade.core.AID;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;

import java.util.ArrayList;
import java.util.Arrays;

class MainController {

    private static final ArrayList<String []> parameters = new ArrayList<>(Arrays.asList(
            new String[]{"5", "2", "4", "8"},
            new String[]{"15", "1", "3", "6"},
            new String[]{"10", "1", "4", "5"},
            new String[]{"3", "1", "3", "8"},
            new String[]{"2", "4", "3", "7", "10"},
            new String[]{"10", "3", "2", "1"},
            new String[]{"10", "6", "2", "10"},
            new String[]{"5", "6", "7", "5", "4"},
            new String[]{"8", "1", "6", "4", "3"},
            new String[]{"10", "9", "7", "5"}));

    void initAgents() {
        // Retrieve the singleton instance of the JADE Runtime
        Runtime rt = Runtime.instance();
        // Create a container to host the Default Agent
        Profile p = new ProfileImpl();
        p.setParameter(Profile.MAIN_HOST, "localhost");
        p.setParameter(Profile.MAIN_PORT, "10098");
        p.setParameter(Profile.GUI, "true");
        ContainerController cc = rt.createMainContainer(p);
        int i=0;

        try {
             for(String[] agentParameter : parameters) {
                 i++;// for agent name
                 AgentController agent = cc.createNewAgent(Integer.toString(i),
                         "ru.spbu.mas.agent.MyAgent", agentParameter);

                 agent.start();
             }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

