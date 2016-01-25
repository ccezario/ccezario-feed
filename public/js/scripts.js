$(document).ready(function(){
    $('#cars').change(function() {
        if($(this).is(":checked")) {
            $("#cars_tags").attr("disabled", false);
        } else {
            $('#cars_tags').attr("disabled", true);
        }
    });
    $('#economy').change(function() {
            if($(this).is(":checked")) {
                $("#economy_tags").attr("disabled", false);
            } else {
                $('#economy_tags').attr("disabled", true);
            }
        });
        $('#education').change(function() {
                if($(this).is(":checked")) {
                    $("#education_tags").attr("disabled", false);
                } else {
                    $('#education_tags').attr("disabled", true);
                }
            });
            $('#foods').change(function() {
                    if($(this).is(":checked")) {
                        $("#foods_tags").attr("disabled", false);
                    } else {
                        $('#foods_tags').attr("disabled", true);
                    }
                });
                $('#games').change(function() {
                        if($(this).is(":checked")) {
                            $("#games_tags").attr("disabled", false);
                        } else {
                            $('#games_tags').attr("disabled", true);
                        }
                    });
                    $('#movies').change(function() {
                            if($(this).is(":checked")) {
                                $("#movies_tags").attr("disabled", false);
                            } else {
                                $('#movies_tags').attr("disabled", true);
                            }
                        });
                        $('#music').change(function() {
                                if($(this).is(":checked")) {
                                    $("#music_tags").attr("disabled", false);
                                } else {
                                    $('#music_tags').attr("disabled", true);
                                }
                            });
                            $('#people').change(function() {
                                    if($(this).is(":checked")) {
                                        $("#people_tags").attr("disabled", false);
                                    } else {
                                        $('#people_tags').attr("disabled", true);
                                    }
                                });
                                $('#places').change(function() {
                                        if($(this).is(":checked")) {
                                            $("#places_tags").attr("disabled", false);
                                        } else {
                                            $('#places_tags').attr("disabled", true);
                                        }
                                    });
                                    $('#politics').change(function() {
                                            if($(this).is(":checked")) {
                                                $("#politics_tags").attr("disabled", false);
                                            } else {
                                                $('#politics_tags').attr("disabled", true);
                                            }
                                        });
                                        $('#sports').change(function() {
                                                if($(this).is(":checked")) {
                                                    $("#sports_tags").attr("disabled", false);
                                                } else {
                                                    $('#sports_tags').attr("disabled", true);
                                                }
                                            });
                                            $('#tech').change(function() {
                                                    if($(this).is(":checked")) {
                                                        $("#tech_tags").attr("disabled", false);
                                                    } else {
                                                        $('#tech_tags').attr("disabled", true);
                                                    }
                                                });
                                                $('#transportation').change(function() {
                                                        if($(this).is(":checked")) {
                                                            $("#transportation_tags").attr("disabled", false);
                                                        } else {
                                                            $('#transportation_tags').attr("disabled", true);
                                                        }
                                                    });
                                                    $('#travel').change(function() {
                                                            if($(this).is(":checked")) {
                                                                $("#travel_tags").attr("disabled", false);
                                                            } else {
                                                                $('#travel_tags').attr("disabled", true);
                                                            }
                                                        });
                                                        $('#tv').change(function() {
                                                                if($(this).is(":checked")) {
                                                                    $("#tv_tags").attr("disabled", false);
                                                                } else {
                                                                    $('#tv_tags').attr("disabled", true);
                                                                }
                                                            });
                                                            $('#weather').change(function() {
                                                                    if($(this).is(":checked")) {
                                                                        $("#weather_tags").attr("disabled", false);
                                                                    } else {
                                                                        $('#weather_tags').attr("disabled", true);
                                                                    }
                                                                });
});