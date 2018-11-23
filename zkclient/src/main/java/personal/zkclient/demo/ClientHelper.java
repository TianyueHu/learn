package personal.zkclient.demo;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.IZkStateListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.Watcher;

import java.util.List;

public class ClientHelper {

    ZkClient client;

    public ClientHelper(ZkClient zkClient){
        this.client = zkClient;
    }

    public void createNode(String path, Object data){
        client.createPersistent(path, data);
    }

    public Object readNode(String path){
        return client.readData(path);
    }

    public void deleteNode(String path){
        client.delete(path);
    }

    public void subscribeState(){
        client.subscribeStateChanges(new IZkStateListener(){

            @Override
            public void handleStateChanged(Watcher.Event.KeeperState keeperState) throws Exception {
                //System.out.println("");
            }

            @Override
            public void handleNewSession() throws Exception {
                //System.out.println("");
            }
        });
    }

    public void subscribeChildChanges(String path){
        client.subscribeChildChanges(path, new IZkChildListener() {
            @Override
            public void handleChildChange(String s, List<String> list) throws Exception {
                for(String child : list){
                    System.out.println("path :" + s + " Child :" + child + "changed");
                }
            }
        });
    }

    public void subscribeDataChanges(String path){
        client.subscribeDataChanges(path, new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println("Node:" + s + "changed");
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println("Node:" + s + "deleted");
            }
        });
    }

}
