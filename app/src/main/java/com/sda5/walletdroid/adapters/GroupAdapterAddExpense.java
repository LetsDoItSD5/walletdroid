
package com.sda5.walletdroid.adapters;

        import android.content.Context;
        import android.content.Intent;
        import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.Toast;

        import com.sda5.walletdroid.R;
        import com.sda5.walletdroid.activities.AddExpenseUsersActivity;
        import com.sda5.walletdroid.activities.GroupDetailActivity;
        import com.sda5.walletdroid.models.Group;

        import java.util.ArrayList;
        import java.util.List;

public class GroupAdapterAddExpense extends ArrayAdapter {
    private Context mContext;
    private final List<Group> groups;


    public GroupAdapterAddExpense(Context context, ArrayList<Group> groups) {
        super(context, 0, groups);
        mContext = context;
        this.groups = groups;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_group_item, parent, false);

        final Group group = groups.get(position);

        Button buttonGroup = listItem.findViewById(R.id.btn_group_item);
        buttonGroup.setText(group.getName());
        buttonGroup.setTag(group.getId());

        buttonGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String groupId = view.getTag().toString();
                Intent intent = new Intent(getContext(), AddExpenseUsersActivity.class);
                intent.putExtra("group_id", groupId);
                getContext().startActivity(intent);
            }
        });
        return listItem;
    }
}