package offic.htk.com.officproject.models.realm;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by Mai Trinh on 8/1/2016.
 */
public class Comment extends RealmObject{

    String cdbody;
    String cdCreatedAt;
    @PrimaryKey
    @Required
    String cdID;
    RealmList<File> fileList = new RealmList<>();
    Note note;
    User user;
}
