/*
 * @copyright 2011 Ridha Chelghaf
 * @license GNU General Public License
 * 
 * This file is part of MansionOfMadnessToolKit.
 *
 * MansionOfMadnessToolKit is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MansionOfMadnessToolKit is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MansionOfMadnessToolKit.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.amphiprion.mansionofmadness.dialog;

import org.amphiprion.mansionofmadness.R;
import org.w3c.dom.Text;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.text.Html;
import android.text.TextUtils;
import android.text.util.*;

public class CombatDialog extends Dialog implements OnClickListener {
	private Context mContext;
	private Spinner mAtkType;
	private Button mDraw;
	private Button mClose;
	private TextView mResult;
	//private RadioGroup mRadioGroup;

	public CombatDialog(Context context) {
		//super(context, R.style.CombatDlgStyle);
		super(context);
		mContext = context;
		/** It will hide the title */
		//requestWindowFeature(Window.FEATURE_NO_TITLE);  

		setContentView(R.layout.combat_resolve);
		setTitle(context.getString(R.string.combat_title));
		
		//mAtkType = (Button) findViewById(R.id.btnAtkType);
		//mAtkType.setOnClickListener(this);
		/*
		mAtkType = (Spinner) findViewById(R.id.spinAtkType);
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
	    		context, R.array.combat_attack_type_array, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    mAtkType.setAdapter(adapter);
	    */
	    mAtkType = (Spinner) findViewById(R.id.spinAtkType);
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
	    		context, R.array.combat_attack_type_array, R.layout.my_spinner_textview);
	    //adapter.setDropDownViewResource(R.layout.my_spinner_textview);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    mAtkType.setAdapter(adapter);
		
		mDraw = (Button) findViewById(R.id.btnDraw);
		mDraw.setOnClickListener(this);
		
		mClose = (Button) findViewById(R.id.btnClose);
		mClose.setOnClickListener(this);
		
		mResult = (TextView) findViewById(R.id.txtResult);		
		
	}

	@Override
	public void onClick(View v) {  
		if (v == mClose){
			dismiss();
		}else if (v == mDraw){
			// TODO retrieve card from db
			displayTxt(mContext.getString(R.string.combat_card_01_inv), 
					mContext.getString(R.string.combat_card_01_inv_success), 
					mContext.getString(R.string.combat_card_01_inv_failure));		
		}
	}
	
	public void displayTxt(String test, String success, String failure){
		String formattedTest = "<font color=#ffffff><b><i>" + test + "</i></b></font>";
		String formattedSuccess = "<font color=#00ff00><b>" + mContext.getString(R.string.combat_card_success) + "&nbsp;" + success + "</b></font>";
		String formattedFailure = "<font color=#ff0000><b>" + mContext.getString(R.string.combat_card_failure) + "&nbsp;" + failure + "</b></font>";		
		mResult.setText(Html.fromHtml(formattedTest + "<br/><br/>" + formattedSuccess + "<br/><br/>" + formattedFailure));
	}

}