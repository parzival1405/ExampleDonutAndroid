package quanghuu.example.donut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import quanghuu.example.donut.model.Donut;

public class secondActivity extends AppCompatActivity {

    ImageView imageS;
    TextView titleS,detailS,priceS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        imageS = findViewById(R.id.imageS);
        titleS = findViewById(R.id.titleS);
        detailS = findViewById(R.id.detailS);
        priceS = findViewById(R.id.priceS);

        Donut donut = getIntent().getParcelableExtra("cake");

        imageS.setImageResource(donut.getImage());
        titleS.setText(donut.getTitle());
        detailS.setText(donut.getDetail());
        priceS.setText(donut.getPrice() + "$");
    }
}