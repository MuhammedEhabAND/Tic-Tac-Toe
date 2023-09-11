/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.retrieve_online_users;

/**
 *
 * @author Mohammed
 */

public interface ServerResponse {
    void onSuccess();

    void onError(String errorMessage);
}

