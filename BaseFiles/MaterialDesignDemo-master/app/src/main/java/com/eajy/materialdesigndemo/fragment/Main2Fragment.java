package com.eajy.materialdesigndemo.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TimePicker;

import com.bumptech.glide.Glide;
import com.eajy.materialdesigndemo.R;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * Created by zhang on 2016.08.07.
 */
public class Main2Fragment extends Fragment implements View.OnClickListener {

    private Button btn_dialog_1, btn_dialog_2, btn_dialog_3, btn_dialog_4, btn_dialog_5,
            btn_dialog_6, btn_dialog_7, btn_dialog_8, btn_dialog_9, btn_dialog_10, btn_dialog_11;
    Calendar calendar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        NestedScrollView nestedScrollView = (NestedScrollView) inflater.inflate(R.layout.fragment_main_2, container, false);

        btn_dialog_1 = (Button) nestedScrollView.findViewById(R.id.btn_dialog_1);
        btn_dialog_2 = (Button) nestedScrollView.findViewById(R.id.btn_dialog_2);
        btn_dialog_3 = (Button) nestedScrollView.findViewById(R.id.btn_dialog_3);
        btn_dialog_4 = (Button) nestedScrollView.findViewById(R.id.btn_dialog_4);
        btn_dialog_5 = (Button) nestedScrollView.findViewById(R.id.btn_dialog_5);
        btn_dialog_6 = (Button) nestedScrollView.findViewById(R.id.btn_dialog_6);
        btn_dialog_7 = (Button) nestedScrollView.findViewById(R.id.btn_dialog_7);
        btn_dialog_8 = (Button) nestedScrollView.findViewById(R.id.btn_dialog_8);
        btn_dialog_9 = (Button) nestedScrollView.findViewById(R.id.btn_dialog_9);
        btn_dialog_10 = (Button) nestedScrollView.findViewById(R.id.btn_dialog_10);
        btn_dialog_11 = (Button) nestedScrollView.findViewById(R.id.btn_dialog_11);

        // ViewGroup viewGroup = (ViewGroup) mRecyclerView.getParent();
        // if (viewGroup != null) { viewGroup.removeAllViews(); }

        return nestedScrollView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        calendar = Calendar.getInstance();

        btn_dialog_1.setOnClickListener(this);
        btn_dialog_2.setOnClickListener(this);
        btn_dialog_3.setOnClickListener(this);
        btn_dialog_4.setOnClickListener(this);
        btn_dialog_5.setOnClickListener(this);
        btn_dialog_6.setOnClickListener(this);
        btn_dialog_7.setOnClickListener(this);
        btn_dialog_8.setOnClickListener(this);
        btn_dialog_9.setOnClickListener(this);
        btn_dialog_10.setOnClickListener(this);
        btn_dialog_11.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_dialog_1:
                new AlertDialog.Builder(getContext())
                        .setMessage(getString(R.string.main_dialog_simple_title))
                        .setPositiveButton(getString(R.string.dialog_ok), null)
                        .show();
                break;

            case R.id.btn_dialog_2:
                new AlertDialog.Builder(getContext())
                        .setTitle(getString(R.string.main_dialog_simple_title))
                        .setMessage(getString(R.string.main_dialog_simple_message))
                        .setPositiveButton(getString(R.string.dialog_ok), null)
                        .setNegativeButton(getString(R.string.dialog_cancel), null)
                        .show();
                break;

            case R.id.btn_dialog_3:
                String[] singleChoiceItems = getResources().getStringArray(R.array.dialog_choice_array);
                int itemSelected = 0;
                new AlertDialog.Builder(getContext())
                        .setTitle(getString(R.string.main_dialog_single_choice))
                        .setSingleChoiceItems(singleChoiceItems, itemSelected, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .setNegativeButton(getString(R.string.dialog_cancel), null)
                        .show();
                break;

            case R.id.btn_dialog_4:
                String[] multiChoiceItems = getResources().getStringArray(R.array.dialog_choice_array);
                boolean[] checkedItems = {true, false, false, false, false};
                new AlertDialog.Builder(getContext())
                        .setTitle(getString(R.string.main_dialog_multi_choice))
                        .setMultiChoiceItems(multiChoiceItems, checkedItems, null)
                        .setPositiveButton(getString(R.string.dialog_ok), null)
                        .setNegativeButton(getString(R.string.dialog_cancel), null)
                        .show();
                break;

            case R.id.btn_dialog_5:
                ProgressDialog progressDialog = new ProgressDialog(getContext());
                progressDialog.setMessage(getString(R.string.main_dialog_progress_title));
                progressDialog.show();
                break;

            case R.id.btn_dialog_6:
                final ProgressDialog horizontalProgressDialog = new ProgressDialog(getContext());
                horizontalProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                horizontalProgressDialog.setMessage(getString(R.string.main_dialog_progress_title));
                horizontalProgressDialog.setCancelable(false);
                horizontalProgressDialog.setMax(100);
                horizontalProgressDialog.show();

                new Thread(new Runnable() {
                    int progress = 0;

                    @Override
                    public void run() {
                        while (progress <= 100) {
                            horizontalProgressDialog.setProgress(progress);
                            if (progress == 100) {
                                horizontalProgressDialog.dismiss();
                            }
                            try {
                                Thread.sleep(35);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            progress++;
                        }
                    }
                }).start();
                break;

            case R.id.btn_dialog_7:
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, monthOfYear);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        String date = DateFormat.getDateInstance(DateFormat.MEDIUM).format(calendar.getTime());
                        btn_dialog_7.setText(date);
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
                break;

            case R.id.btn_dialog_8:
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        calendar.set(Calendar.HOUR_OF_DAY, i);
                        calendar.set(Calendar.MINUTE, i1);
                        String time = DateFormat.getTimeInstance(DateFormat.SHORT).format(calendar.getTime());
                        btn_dialog_8.setText(time);
                    }
                }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
                timePickerDialog.show();
                break;

            case R.id.btn_dialog_9:
                final BottomSheetDialog mBottomSheetDialog = new BottomSheetDialog(getContext());
                View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialog_bottom_sheet, null);
                Button btn_dialog_bottom_sheet_ok = (Button) dialogView.findViewById(R.id.btn_dialog_bottom_sheet_ok);
                Button btn_dialog_bottom_sheet_cancel = (Button) dialogView.findViewById(R.id.btn_dialog_bottom_sheet_cancel);
                ImageView img_bottom_dialog = (ImageView) dialogView.findViewById(R.id.img_bottom_dialog);
                Glide.with(getContext()).load(R.drawable.bottom_dialog).into(img_bottom_dialog);
                mBottomSheetDialog.setContentView(dialogView);

                btn_dialog_bottom_sheet_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mBottomSheetDialog.dismiss();
                    }
                });
                btn_dialog_bottom_sheet_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mBottomSheetDialog.dismiss();
                    }
                });
                mBottomSheetDialog.show();
                break;

            case R.id.btn_dialog_10:
                final Dialog fullscreenDialog = new Dialog(getContext(), R.style.DialogFullscreen);
                fullscreenDialog.setContentView(R.layout.dialog_fullscreen);
                ImageView img_full_screen_dialog = (ImageView) fullscreenDialog.findViewById(R.id.img_full_screen_dialog);
                Glide.with(getContext()).load(R.drawable.google_assistant).into(img_full_screen_dialog);
                ImageView img_dialog_fullscreen_close = (ImageView) fullscreenDialog.findViewById(R.id.img_dialog_fullscreen_close);
                img_dialog_fullscreen_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        fullscreenDialog.dismiss();
                    }
                });
                fullscreenDialog.show();
                break;

            case R.id.btn_dialog_11:
                PopupMenu popupMenu = new PopupMenu(getContext(), btn_dialog_11);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu_main, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return false;
                    }
                });
                popupMenu.show();
                break;

        }
    }
}
