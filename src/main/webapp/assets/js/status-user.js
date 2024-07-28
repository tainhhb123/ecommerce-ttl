/**
 * 
 */

document.querySelectorAll('.form-check-input.status-switch').forEach(checkbox => {
    checkbox.addEventListener('change', function() {
        const userId = this.getAttribute('data-user-id');
        const newStatus = this.checked ? 1 : 0;
        const currentStatus = this.getAttribute('data-current-status'); // Lưu trạng thái hiện tại của checkbox

        let confirmationMessage;

        if (currentStatus == 1 && newStatus == 0) {
            confirmationMessage = 'Bạn có chắc chắn chặn người dùng này không?';
        } else if (currentStatus == 0 && newStatus == 1) {
            confirmationMessage = 'Bạn có chắc chắn muốn thêm người dùng này trở lại không?';
        }

        // Hiển thị hộp thoại xác nhận nếu có thông báo
        if (confirmationMessage && !confirm(confirmationMessage)) {
            // Nếu người dùng hủy, hoàn tác thay đổi trạng thái của checkbox
            this.checked = !this.checked;
            return;
        }

        // Cập nhật trạng thái người dùng
        fetch('AdUpdateUser', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: new URLSearchParams({
                'userId': userId,
                'status': newStatus
            }).toString()
        })
        .then(response => {
            if (response.ok) {
                console.log('Status updated successfully');
            } else {
                console.error('Error updating status');
            }
        })
        .catch(error => console.error('Fetch error:', error));
    });
});