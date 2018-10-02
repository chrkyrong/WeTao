/**
 * Created by hzb on 2018/10/01.
 */

$(document).ready(function() {
    //init data
    $('<option></option>').text('请选择省份').appendTo($('#ddlProvince'));
    $('<option></option>').text('请选择城市').appendTo($('#ddlCity'));
    $('<option></option>').text('请选择地区').appendTo($('#ddlDistrict'));
    $.getJSON('static/js/area_hzb.json', function(data) {
        $.each(data, function(i, n) {
            $('<option></option>').text(n.name).appendTo($('#ddlProvince'));
        });
    });
    //province change
    $('#ddlProvince').change(function() {
        $('#ddlCity,#ddlDistrict').empty();
        $('<option></option>').text('请选择城市').appendTo($('#ddlCity'));
        $('<option></option>').text('请选择地区').appendTo($('#ddlDistrict'));
        var pro = $(this).val();
        $.getJSON('static/js/area_hzb.json', function(data) {
            $.each(data, function(i, n) {
                if(pro == n.name) {
                    $.each(n.sub, function(i_1, n_1) {
                        $('<option></option>').text(n_1.name).appendTo($('#ddlCity'));
                    });
                }
            });
        });
    });
    //city change
    $('#ddlCity').change(function() {
        $('#ddlDistrict').empty();
        $('<option></option>').text('请选择地区').appendTo($('#ddlDistrict'));
        var pro = $('#ddlProvince').val();
        var city = $(this).val();
        $.getJSON('static/js/area_hzb.json', function(data) {
            $.each(data, function(i, n) {
                if(pro == n.name) {
                    $.each(n.sub, function(i_1, n_1) {
                        if(city == n_1.name) {
                            $.each(n_1.sub, function(i_2, n_2) {
                                if(n_2.name != '市辖区') {
                                    $('<option></option>').text(n_2.name).appendTo($('#ddlDistrict'));
                                }
                            });
                        }
                    });
                }
            });
        });
    });
});