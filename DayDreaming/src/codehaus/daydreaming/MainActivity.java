package codehaus.daydreaming;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import codehaus.daydreaming.FileOperations;

public class MainActivity extends Activity {
	  EditText fname,fcontent,fnameread;
	  Button write,read,vall;
	  TextView filecon;
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	    final Context context = this;
	    fname = (EditText)findViewById(R.id.fname);
	    fcontent = (EditText)findViewById(R.id.ftext);
	    fnameread = (EditText)findViewById(R.id.fnameread);
	    write = (Button)findViewById(R.id.btnwrite);
	    read = (Button)findViewById(R.id.btnread);
	    filecon = (TextView)findViewById(R.id.filecon);
	    vall = (Button)findViewById(R.id.btnall);
	    vall.setOnClickListener(new OnClickListener() {
	    	 
			@Override
			public void onClick(View arg0) {
			Intent intent = new Intent(context, FileSelector.class);
                            startActivity(intent); }
	    	});
	        write.setOnClickListener(new View.OnClickListener() {
	    @Override
	    public void onClick(View arg0) {
	      // TODO Auto-generated method stub
	    String filename = fname.getText().toString();
	    String filecontent = fcontent.getText().toString();
	    FileOperations fop = new FileOperations();
	    fop.write(filename, filecontent);
	    if(fop.write(filename, filecontent)){
	    Toast.makeText(getApplicationContext(), filename+".txt created", Toast.LENGTH_SHORT).show();
	    }else{
	      Toast.makeText(getApplicationContext(), "I/O error", Toast.LENGTH_SHORT).show();
	    }
	    }
	  });
	  read.setOnClickListener(new View.OnClickListener() {
	    @Override
	    public void onClick(View arg0) {
	      // TODO Auto-generated method stub
	      String readfilename = fnameread.getText().toString();
	      FileOperations fop = new FileOperations();
	      String text = fop.read(readfilename);
	      if(text != null){
	      filecon.setText(text);
	      }
	      else {
	        Toast.makeText(getApplicationContext(), "File not Found", Toast.LENGTH_SHORT).show();
	        filecon.setText(null);
	      }
	    }
	  });
	  }
	  }
